<template>
  <el-form :inline='true'>
    <el-form-item label='角色名'>
      <el-input v-model='crud.listQuery.name' />
    </el-form-item>
    <el-form-item>
      <el-button type='success' @click='crud.searchList()'>查找</el-button>
      <el-button @click='crud.restListQuery()'>重置</el-button>
      <el-button type='primary' @click='crud.showModel()'>添加</el-button>
    </el-form-item>
  </el-form>
  <el-table :data='crud.data.list' border style='width: 100%; margin-top: 10px'>
    <el-table-column prop='name' label='角色名' />
    <el-table-column prop='remark' label='备注' />
    <el-table-column prop='createTime' label='创建时间' />
    <el-table-column label='操作'>
      <template v-slot='{ row }'>
        <el-button type='primary' text bg size='small' @click='crud.showModel(row)'>编辑</el-button>
        <el-button type='primary' text bg size='small' @click='assign(row.id)'>分配权限</el-button>
        <el-button type='warning' text bg size='small' @click='crud.deleteItem(row.id)'>删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <div class='page'>
    <el-pagination
      background
      layout='prev, pager, next'
      :total='crud.pagination.total'
      @current-change='crud.getList({ page: $event })'
    />
  </div>

  <el-dialog v-model='crud.tempFrom.showModel' title='新增' width='400px'>
    <el-form :model='crud.tempFrom' ref='formModel' label-width='80px' :rules='rules'>
      <el-form-item label='角色名' prop='name' required>
        <el-input v-model='crud.tempFrom.name' :disabled='crud.tempFrom.id!==null' />
      </el-form-item>
      <el-form-item label='备注' prop='remark'>
        <el-input v-model='crud.tempFrom.remark' type='textarea' />
      </el-form-item>
      <el-form-item>
        <el-button @click='crud.cancel()'>取消</el-button>
        <el-button type='primary' @click='submit'>确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>

  <el-dialog v-model='assignVisible' title='分配权限' width='500px'>
    <el-form>
      <el-form-item>
        <el-tree
          ref='treeRef'
          :data='menuList'
          show-checkbox
          default-expand-all
          node-key='id'
          highlight-current
          :props='defaultProps'
        />
      </el-form-item>
      <el-form-item>
        <div style='margin: 0 auto'>
          <el-button @click='assignVisible=false'>取消</el-button>
          <el-button type='primary' @click='assignSubmit'>确定</el-button>
        </div>
      </el-form-item>
    </el-form>
  </el-dialog>

</template>
<script lang='ts' setup>
import { reactive, ref } from 'vue'
import { Crud } from '@/hooks/crud'
import { addRole, assignRole, delRole, editRole, getRoleDetail, getRoleList, getRoleMenuList } from '@/api/system/role'
import { getMenuList } from '@/api/system/menu'
import type { FormRules } from 'element-plus'
import { RoleAssignForm, RoleSearch, RoleVO } from '@/types/system/role'
import { Menu } from '@/types/system/menu'
import { ElMessage } from 'element-plus'

const listQuery: RoleSearch = {
  name: undefined,
  page: 1,
  size: 10
}
const crud = new Crud<RoleVO>({
  apiList: {
    L: getRoleList,
    D: delRole,
    R: getRoleDetail,
    C: addRole,
    U: editRole
  },
  listQuery,
  tempFrom: {
    name: '',
    remark: ''
  }
})
crud.getList()
const formModel = ref()
const rules = reactive<FormRules>({
  name: [
    { required: true, message: '角色名不能为空', trigger: 'blur' }
  ]
})
const assignVisible = ref(false)
const treeRef = ref()
const menuList = ref<Menu[]>([])
const assignForm = reactive<RoleAssignForm>({
  id: '',
  menuList: []
})
const assign = async (id: string) => {
  assignVisible.value = true
  assignForm.id = id
  const { data } = await getRoleMenuList(id)
  if (!data) return
  menuList.value = data.menuList
  treeRef.value.setCheckedKeys(data.roleMenuList)
}
const assignSubmit = () => {
  assignForm.menuList = treeRef.value.getCheckedKeys()
  assignRole(assignForm).then(res => {
    if (res) {
      ElMessage.success(res.msg || '操作成功')
    }
    assignVisible.value = false
  })
}
const defaultProps = {
  children: 'children',
  label: 'title'
}
const submit = async () => {
  if (!formModel) return
  await formModel.value.validate((valid: any, fields: any) => {
    if (valid) {
      crud.addEditItem()
    }
  })
}
</script>
<style lang='scss' scoped>
.page {
  margin-top: 20px;

  > div {
    display: flex;
    justify-content: center;
  }
}
</style>