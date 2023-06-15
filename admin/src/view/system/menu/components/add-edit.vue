<template>
  <el-dialog v-model="visible" :title="title" width="400px">
    <el-form :model="dataForm" ref="formModel" label-width="100px">
      <el-form-item label="父级菜单" prop="pid">
        <el-tree-select v-model="dataForm.pid" :data="treeMenuList" check-strictly :render-after-expand="false" />
      </el-form-item>
      <el-form-item label="菜单标题" prop="title">
        <el-input v-model="dataForm.title" />
      </el-form-item>
      <el-form-item label="路由名称" prop="name">
        <el-input v-model="dataForm.name" />
      </el-form-item>
      <el-form-item label="菜单路径" prop="path">
        <el-input v-model="dataForm.path" />
      </el-form-item>
      <el-form-item label="重定向路径" prop="redirect">
        <el-input v-model="dataForm.redirect" />
      </el-form-item>
      <el-form-item label="菜单图标" prop="icon">
        <Icon-picker v-model="dataForm.icon"></Icon-picker>
      </el-form-item>
      <el-form-item>
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="submit">确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script lang="ts" setup>
import { inject, ref, Ref } from 'vue'
import { addEmployee, editEmployee, getEmployeeDetail } from '@/api/employee'
import { ElMessage } from 'element-plus'
import { Menu, MenuForm } from '@/types/system/menu'
import { addMenu, getMenuDetail, updateMenu } from '@/api/system/menu'
import IconPicker from '@/components/IconPicker/index.vue'

const menuList: Ref<Menu[]> = inject('menuList')!
const treeMenuList = ref()
const visible = ref<boolean>(false)
const title = ref<string>('新建')
const emit = defineEmits(['getList'])
const formModel = ref()

let dataForm = ref<MenuForm>({
  name: '',
  title: '',
  pid: '',
  redirect: '',
  icon: '',
  path: ''
})
const value = ref()

function createTreeData() {
  return [
    {
      label: '顶级菜单',
      value: '0',
      children: menuList.value.map((item) => {
        return {
          label: item.title,
          value: item.id,
          children: item.children.map((child) => {
            return {
              label: child.title,
              value: child.id
            }
          })
        }
      })
    }
  ]
}

const init = async (id: string) => {
  visible.value = true
  treeMenuList.value = createTreeData()
  dataForm.value.id = id
  if (id) {
    title.value = '编辑'
    const result = await getMenuDetail(id)
    if (result) dataForm.value = result.data
  } else {
    title.value = '新建'
    if (formModel.value) {
      formModel.value.resetFields()
    }
  }
}

const submit = () => {
  const submitFunc = dataForm.value.id ? updateMenu : addMenu
  submitFunc(dataForm.value).then((res) => {
    if (res) {
      ElMessage.success('操作成功')
      visible.value = false
      emit('getList')
    }
  })
}

defineExpose({
  init
})
</script>
<style scoped></style>