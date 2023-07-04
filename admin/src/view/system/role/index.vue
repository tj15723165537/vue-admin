<template>
  <el-form :inline='true'>
    <el-form-item label='账号'>
      <el-input v-model='crud.listQuery.account' />
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
      <el-form-item label='用户名' prop='name' required>
        <el-input v-model='crud.tempFrom.name' />
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
</template>
<script lang='ts' setup>
import { delUser, editUser, getUserDetail, getUserList } from '@/api/system/user'
import { watch, reactive, ref } from 'vue'
import { Crud } from '@/hooks/crud'
import { User, UserSearch } from '@/types/system/user'
import { addRole, getRoleList } from '@/api/system/role'
import type { FormRules, RuleForm } from 'element-plus'

const listQuery: UserSearch = {
  account: undefined,
  status: undefined,
  page: 1,
  size: 10
}
const crud = new Crud<User>({
  apiList: {
    L: getRoleList,
    D: delUser,
    R: getUserDetail,
    C: addRole,
    U: editUser
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
    { required: true, message: 'Please input Activity name', trigger: 'blur' }
  ]
})
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