<template>
  <div class="login">
    <form>
      <div class="segment">
        <h1>LOGIN</h1>
      </div>
      <label>
        <input type="text" placeholder="账号" v-model="formStatus.account"/>
      </label>
      <label>
        <input type="password" placeholder="密码" v-model="formStatus.password"/>
      </label>
      <button class="red" type="button" @click.prevent="submit">登 录</button>
    </form>
  </div>
</template>
<script lang="ts" setup>
import {reactive, ref} from 'vue'
import {useRouter} from 'vue-router'
import {login} from '@/api/common'
import type {FormRules, FormInstance} from 'element-plus'
import {useCommonStore} from '@/store/modules/common'
import {ElMessage} from 'element-plus'
import { LoginForm } from '@/types/common'
const router = useRouter()
const store: any = useCommonStore()
const formStatus = reactive<LoginForm>({
  account: '',
  password: ''
})
const rules = reactive<LoginForm>({
  account: '请输入账号',
  password: '请输入密码'
})

const verify = (): boolean => {
  for (let i in formStatus) {
    if (!!(formStatus as any)[i]) {
    } else {
      ElMessage.warning((rules as any)[i])
      return false
    }
  }
  return true
}
const submit = async () => {
  if (verify()) {
    login(formStatus).then((res) => {
      store.setToken(res.data.token!)
      router.push('./home')
    })
  }
}
</script>
<style lang="scss" scoped>
$ruler: 16px;
$color-red: #ae1100;
$color-bg: #ebecf0;
$color-shadow: #babecc;
$color-white: #fff;

.login {
  background-color: $color-bg;
  height: 100vh;
  display: flex;
  align-items: center;
}

p,
input,
select,
textarea,
button {
  font-family: 'Montserrat', sans-serif;
  letter-spacing: -0.2px;
  font-size: $ruler;
}

div,
p {
  color: $color-shadow;
  text-shadow: 1px 1px 1px $color-white;
}

form {
  padding: $ruler;
  width: $ruler * 20;
  margin: 0 auto;
}

.segment {
  padding: $ruler * 2 0;
  text-align: center;
}

button,
input {
  border: 0;
  outline: 0;
  font-size: $ruler;
  border-radius: $ruler * 20;
  padding: $ruler;
  background-color: $color-bg;
  text-shadow: 1px 1px 0 $color-white;
}

label {
  display: block;
  margin-bottom: $ruler * 1.5;
  width: 100%;
}

input {
  margin-right: calc($ruler / 2);
  box-shadow: inset 2px 2px 5px $color-shadow, inset -5px -5px 10px $color-white;
  width: 100%;
  box-sizing: border-box;
  transition: all 0.2s ease-in-out;
  appearance: none;
  -webkit-appearance: none;

  &:focus {
    box-shadow: inset 1px 1px 2px $color-shadow, inset -1px -1px 2px $color-white;
  }
}

button {
  color: #61677c;
  font-weight: bold;
  box-shadow: -5px -5px 20px $color-white, 5px 5px 20px $color-shadow;
  transition: all 0.2s ease-in-out;
  cursor: pointer;
  font-weight: 600;

  &:hover {
    box-shadow: -2px -2px 5px $color-white, 2px 2px 5px $color-shadow;
  }

  &:active {
    box-shadow: inset 1px 1px 2px $color-shadow, inset -1px -1px 2px $color-white;
  }

  .icon {
    margin-right: calc($ruler / 2);
  }

  &.unit {
    border-radius: calc($ruler / 2);
    line-height: 0;
    width: $ruler * 3;
    height: $ruler * 3;
    display: inline-flex;
    justify-content: center;
    align-items: center;
    margin: 0 calc($ruler / 2);
    font-size: $ruler * 1.2;

    .icon {
      margin-right: 0;
    }
  }

  &.red {
    display: block;
    width: 100%;
    color: $color-red;
  }
}

.input-group {
  display: flex;
  align-items: center;
  justify-content: flex-start;

  label {
    margin: 0;
    flex: 1;
  }
}
</style>