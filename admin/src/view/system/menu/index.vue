<template>
  <el-form :inline="true">
    <el-form-item>
      <el-button type="primary" @click="addOrEdit()">添加</el-button>
    </el-form-item>
  </el-form>
  <el-table
          :data="dataList"
          style="width: 100%; margin-bottom: 20px"
          row-key="id"
          border
          default-expand-all
  >
    <el-table-column prop="title" label="名称"/>
    <el-table-column prop="path" label="路径"/>
    <el-table-column prop="redirect" label="重定向"/>
    <el-table-column label="操作">
      <template v-slot="{ row }">
        <el-button type="primary" text bg size="small" @click="addOrEdit(row.id)">编辑</el-button>
        <el-button type="warning" text bg size="small" @click="del(row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <Add-edit ref="addEditRef" @getList="getList"/>
</template>
<script lang="ts" setup>
import {delMenu, getMenuList} from '@/api/system/menu'
import {provide, ref} from 'vue'
import {Menu} from '@/types/system/menu'
import {ElMessage, ElMessageBox} from "element-plus";
import AddEdit from './components/add-edit.vue'
const dataList = ref<Menu[]>([])
provide('menuList', dataList)
const getList = async () => {
    const result = await getMenuList()
    if (result) {
        dataList.value = result.data
    }
}
getList()
const addEditRef = ref()
const addOrEdit = (id?: string) => {
    addEditRef.value.init(id)
}
const del = (id: string) => {
    ElMessageBox.confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(async () => {
        let result = await delMenu(id)
        if (!result) return ElMessage.error('删除失败')
        ElMessage({
            type: 'success',
            message: '操作成功'
        })
        getList()
    })
}
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
