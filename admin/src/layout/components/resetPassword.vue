<template>
  <div @click.stop='showModel'>
    修改密码
  </div>
  <el-dialog v-model='visible' title='修改密码' width='400px' :append-to-body='true'>
    <el-form :model='dataForm' ref='formModel' label-width='100px' :rules='rules'>
      <el-form-item label='原密码' prop='oldPassword'>
        <el-input v-model='dataForm.oldPassword' />
      </el-form-item>
      <el-form-item label='新密码' prop='newPassword'>
        <el-input v-model='dataForm.newPassword' type='password' show-password />
      </el-form-item>
      <el-form-item label='确认新密码' prop='confirmNewPassword'>
        <el-input v-model='dataForm.confirmNewPassword' type='password' show-password />
      </el-form-item>
      <el-form-item>
        <el-button @click='visible = false'>取消</el-button>
        <el-button type='primary' @click='submit'>确定</el-button>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script lang='ts' setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { ResetPasswordForm } from '@/types/common'
import { resetPassword } from '@/api/common'
import { ElMessage } from 'element-plus'

const visible = ref<boolean>(false)
const formModel = ref<FormInstance>()
let dataForm = ref<ResetPasswordForm>({})

interface RuleForm {
  oldPassword: string
  newPassword: string
  confirmNewPassword: string
}

const rules = reactive<FormRules<RuleForm>>({
  oldPassword: [
    { required: true, message: '请输入原密码', trigger: 'blur' }
  ],
  newPassword: [
    { required: true, message: '请输入新密码', trigger: 'blur' },
    { min: 6, message: '密码最少为6位', trigger: 'blur' }
  ],
  confirmNewPassword: [
    { required: true, message: '请再次输入新密码', trigger: 'blur' },
    { min: 6, message: '密码最少为6位', trigger: 'blur' },
    {
      validator: (rule, value, callback) => {
        if (value === dataForm.value.newPassword) {
          callback()
        } else {
          callback(new Error('两次输入密码不一致'))
        }
      }, trigger: 'blur'
    }
  ]
})
const showModel = async () => {
  visible.value = true
  if (formModel.value) {
    formModel.value.resetFields()
  }
}
const submit = async () => {
  try {
    await formModel.value?.validate()
    const data = {
      oldPassword: dataForm.value.oldPassword,
      newPassword: dataForm.value.newPassword
    }
    resetPassword(dataForm.value).then((res) => {
      ElMessage.success('操作成功')
      visible.value = false
    })
  } catch (e) {
  }
}
</script>
<style scoped></style>
