<template>
  <el-dialog v-model="visible" :title="title" width="400px">
    <el-form :model="dataForm" ref="formModel" label-width="80px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="dataForm.name"/>
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input v-model="dataForm.phone"/>
      </el-form-item>
      <el-form-item label="入职日期" prop="date">
        <el-date-picker v-model="dataForm.date" type="date"/>
      </el-form-item>
      <el-form-item label="住址" prop="address">
        <el-input v-model="dataForm.address"/>
      </el-form-item>
      <el-form-item>
        <el-button @click="visible = false">取消</el-button>
        <el-button type="primary" @click="submit">确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script lang="ts" setup>
import {ref} from 'vue'
import {addEmployee, editEmployee, getEmployeeDetail} from '@/api/employee'
import {ElMessage} from 'element-plus'
import {EmployeeForm} from '@/types/employee/employee'

const visible = ref<boolean>(false)
const title = ref<string>('新建')
const emit = defineEmits(['getList'])
const formModel = ref()

let dataForm = ref<EmployeeForm>({
  name: '',
  phone: '',
  address: ''
})

const init = async (id: number) => {
  visible.value = true
  dataForm.value.id = id
  if (id) {
    title.value = '编辑'
    const result = await getEmployeeDetail(id)
    if (result) dataForm.value = result.data
  } else {
    title.value = '新建'
    if (formModel.value) {
      formModel.value.resetFields()
    }
  }
}

const submit = () => {
  const submitFunc = dataForm.value.id ? editEmployee : addEmployee
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
