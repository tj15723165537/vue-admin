<template>
  <el-form :inline="true">
    <el-form-item label="账号">
      <el-input v-model="crud.listQuery.account"/>
    </el-form-item>
    <el-form-item label="状态">
      <el-select v-model="crud.listQuery.status" placeholder="请选择">
        <el-option label="正常" :value="1"/>
        <el-option label="禁用" :value="0"/>
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="success" @click="crud.searchList()">查找</el-button>
      <el-button @click="crud.restListQuery()">重置</el-button>
      <el-button type="primary" @click="crud.showModel()">添加</el-button>
    </el-form-item>
  </el-form>
  <el-table :data="crud.data.list" border style="width: 100%; margin-top: 10px">
    <el-table-column prop="account" label="账号"/>
    <el-table-column prop="createTime" label="创建时间"/>
    <el-table-column prop="updateTime" label="更新时间"/>
    <el-table-column prop="status" label="状态">
      <template v-slot="{ row }">
        <el-switch v-model="row.status" @change="updateStatus(row.id)"/>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template v-slot="{ row }">
        <el-button type="primary" text bg size="small" @click="crud.showModel(row)">编辑</el-button>
        <el-button type="warning" text bg size="small" @click="crud.deleteItem(row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <div class="page">
    <el-pagination
        background
        layout="prev, pager, next"
        :total="crud.pagination.total"
        @current-change="crud.getList({ page: $event })"
    />
  </div>

  <el-dialog v-model="crud.tempFrom.showModel" :title="crud.tempFrom.id ? '编辑' : '新增'" width="400px">
    <el-form :model="crud.tempFrom" ref="formModel" label-width="80px">
      <el-form-item label="账号" prop="account">
        <el-input v-model="crud.tempFrom.account"/>
      </el-form-item>
      <el-form-item label="角色" prop="role">
        <el-radio-group v-model="crud.tempFrom.role">
          <el-radio :label="item.id" v-for='item in roleList' size="large">{{item.name}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="状态">
        <el-switch v-model="crud.tempFrom.status" :active-value="1" :inactive-value="0"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="crud.cancel()">取消</el-button>
        <el-button type="primary" @click="crud.addEditItem()">确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script lang="ts" setup>
import { addUser, delUser, editUser, getUserDetail, getUserList, updateUserStatus } from '@/api/system/user'
import { watch,ref } from 'vue'
import { Crud } from '@/hooks/crud'
import { ElMessage } from 'element-plus/es'
import { User, UserSearch } from '@/types/system/user'
import { getAllRoleList } from '@/api/system/role'
import { RoleVO } from '@/types/system/role'
import { log } from 'echarts/types/src/util/log'

const listQuery: UserSearch = {
  account: undefined,
  status: undefined,
  page: 1,
  size: 10
}
const crud = new Crud<User>({
  apiList: {
    L: getUserList,
    D: delUser,
    R: getUserDetail,
    C: addUser,
    U: editUser
  },
  listQuery,
  tempFrom: {
    account: '',
    status: 1,
    role:''
  }
})
crud.getList()
watch(
    () => crud.data.list,
    (val) => {
      val.map((item) => {
        item.status = item.status ? true : false
      })
    }
)
const updateStatus = (id: number) => {
  updateUserStatus(id).then((res) => {
    ElMessage.success(res.msg || '操作成功')
  }).catch((err)=>{
    crud.getList()
  })
}
const roleList = ref<RoleVO[]>()
const getRoleList = async ()=>{
  const {data}  = await getAllRoleList()
  roleList.value = data
}
getRoleList()
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