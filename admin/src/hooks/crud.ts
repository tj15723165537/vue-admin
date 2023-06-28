import {ElMessage, ElMessageBox} from 'element-plus'
import {reactive} from 'vue'

export interface IcrudModel {
  rowIdText?: string // 所有的crud操作的是哪一个字段
  tempFrom?: any // 添加的表单对象
  apiList: {
    C?: Function
    U?: Function
    R?: Function
    D?: Function
    L?: Function
  }
  listQuery?: {
    page: number
    size: number
    [propName: string]: any
  }
  list?: any[]
  success?: Function
  fail?: Function
}

export class Crud<T> {
  rowIdText: string
  tempFrom: any
  apiList: {
    L?: Function
    C?: Function
    U?: Function
    D?: Function
    R?: Function
  }
  success
  fail
  listQuery
  listQueryCopy
  tempCopy
  data: {
    list: T[]
  }
  pagination: {
    total: number
    page: number
    size: number
  }

  constructor(obj: IcrudModel) {
    this.pagination = reactive({
      position: ['bottomRight '],
      showSizeChanger: true,
      showQuickJumper: true,
      total: 0,
      size: 10,
      page: 1,
      showTotal: (total: number) => `共 ${total} 条数据`,
      sizeOptions: ['10', '20', '50', '100'],
      onChange: (page: number, size: number) => {
        this.pagination.page = page
        this.pagination.size = size
        this.getList(this.pagination)
      }
    })

    // 表格数据
    this.data = reactive({
      list: obj.list || []
    })

    this.rowIdText = obj.rowIdText || 'id'
    this.apiList = obj.apiList
    this.success = obj.success
    this.fail = obj.fail

    // 请求参数
    this.listQuery = reactive({...obj.listQuery})
    this.listQueryCopy = {...obj.listQuery}

    // 弹窗展示内容
    this.tempFrom = reactive({showModel: false, ...obj.tempFrom})
    this.tempCopy = {showModel: false, ...obj.tempFrom}
  }

  // 获取数据
  getList(page?: any, expand?: any) {
    if (page) {
      this.listQuery.size = page.size || 10
      this.listQuery.page = page.page || 1
    }
    return this.apiList['L']!(this.listQuery).then((res: Response<ResultData<T>>) => {
      if (res.code === 200) {
        this.data.list = res.data.content
        // this.data.list = expand && expand.list ? res.data[expand.list] : res.data
        this.pagination.total = res.data.total!
        // this.pagination.total = expand && expand.total ? Number(res.data[expand.total]) : res.total
        return res
      }
    })
  }

  // 搜索
  searchList() {
    this.listQuery.page = 1
    this.getList()
  }

  // 重置表单
  restListQuery() {
    Object.keys(this.listQueryCopy).forEach((el) => {
      this.listQuery[el] = this.listQueryCopy[el]
    })
  }

  // 添加修改数据
  addEditItem() {
    let params = {...this.tempFrom}
    delete params.showModel
    if (!params.id) {
      delete params.id
      return this.apiList['C']!(params).then((res: any) => {
        if (res.code === 200) {
          this.tempFrom.showModel = false
          this.getList()
          ElMessage.success('添加成功')
          return res
        }
      })
    } else {
      return this.apiList['U']!(params).then((res: any) => {
        if (res.code === 200) {
          this.tempFrom.showModel = false
          this.getList()
          ElMessage.success('修改成功')
          return res
        }
      })
    }
  }

  /**
   * @param id
   * 删除数据
   */
  deleteItem(id: number) {
    ElMessageBox.confirm('您确定删除这一项吗？', '警告', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning'
    })
        .then(async (res) => {
          this.apiList['D']!(id).then((res: any) => {
            if (res.code === 200) {
              this.getList()
              ElMessage.success('删除成功!')
            } else {
              ElMessage.error('删除失败!')
            }
          })
        })
        .catch(() => {
        })
  }

  // 取消
  cancel() {
    this.tempFrom.showModel = false
  }

  /**
   * @name 展示弹窗
   * @param row
   * 弹窗展示你的每一行数据 实现新增或者编辑
   */
  async showModel(row?: any) {
    if (row && row[this.rowIdText]) {
      let data: any = await this.getDetail(row)
      for (const key in this.tempFrom) {
        if (Object.prototype.hasOwnProperty.call(this.tempFrom, key)) {
          this.tempFrom[key] = data[key]
        }
      }
      this.tempFrom[this.rowIdText] = row[this.rowIdText]
    } else {
      Object.keys(this.tempCopy).forEach((rl) => (this.tempFrom[rl] = this.tempCopy[rl]))
      this.tempFrom[this.rowIdText] = null
    }
    this.tempFrom.showModel = true
  }

  //
  getDetail(row: any) {
    return new Promise((resolve, reject) => {
      if (this.apiList['R']!) {
        // 获取详情
        this.apiList['R']!(row[this.rowIdText]).then((res: any) => {
          let temp = res.data
          resolve(temp)
        })
      } else {
        resolve(row)
      }
    })
  }
}
