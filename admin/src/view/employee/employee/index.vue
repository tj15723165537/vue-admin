<template>
  <el-form :inline="true">
    <el-form-item label="姓名">
      <el-input v-model="searchState.name"/>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="searchState.phone"/>
    </el-form-item>
    <el-form-item label="家庭住址">
      <el-input v-model="searchState.address"/>
    </el-form-item>
    <el-form-item>
      <el-button type="success" @click="search">查找</el-button>
      <el-button @click="reset">重置</el-button>
      <el-button type="primary" @click="addOrEdit(undefined)">添加</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="tableData" border style="width: 100%; margin-top: 10px">
    <el-table-column prop="name" label="姓名"/>
    <el-table-column prop="phone" label="电话"/>
    <el-table-column prop="date" label="入职日期"/>
    <el-table-column prop="address" label="家庭住址"/>
    <el-table-column label="操作">
      <template v-slot="{ row }">
        <el-button type="primary" text bg size="small" @click="addOrEdit(row.id)">编辑</el-button>
        <el-button type="warning" text bg size="small" @click="del(row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <div class="page">
    <el-pagination background layout="prev, pager, next, jumper, sizes, total" :total="total"
                   @current-change="pageChange" @size-change="sizeChange"/>
  </div>
  <add-edit ref="addEditRef" @getList="getList"/>
</template>
<script lang="ts" setup>
import {delEmployee, getEmployeeList} from '@/api/employee/index'
import {onMounted, reactive, ref} from 'vue'
import addEdit from './components/add-edit.vue'
import {ElMessageBox, ElMessage} from 'element-plus'
import {EmployeeSearch, Employee} from '@/types/employee/employee'
let searchState = reactive<EmployeeSearch>({
    page: 1,
    size: 10,
    name: '',
    phone: '',
    address: ''
})

let tableData = ref<Array<Employee>>([])
let total = ref<number>(0)
const addEditRef = ref()

const addOrEdit = (id?: number) => {
    addEditRef.value.init(id)
}
const del = (id: number) => {
    ElMessageBox.confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(async () => {
        let result = await delEmployee(id)
        if (!result) return ElMessage.error('删除失败')
        ElMessage({
            type: 'success',
            message: '操作成功'
        })
        getList()
    })
}
const getList = async () => {
    let result = await getEmployeeList(searchState)
    tableData.value = result.data.content
    total.value = result.data!.total!
}
const reset = () => {
    let i: keyof EmployeeSearch
    for (i in searchState) {
        if (i !== 'page' && i !== 'size') searchState[i] = ''
    }
}
const pageChange = (page: number) => {
    searchState.page = page
    getList()
}
const sizeChange = (size: number) => {
    searchState.size = size
    searchState.page = 1
    getList()
}
const search = () => {
    searchState.page = 1
    getList()
}

getList()

</script>
<style lang="scss" scoped>
.page {
  margin-top: 20px;

  > div {
    display: flex;
    justify-content: center;
  }
}
</style>
