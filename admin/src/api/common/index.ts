import request from '@/utils/request'
import { LoginForm, LoginResult } from '@/types/common'
import { Menu } from '@/types/system/menu'

export const login = (data: LoginForm) => {
  return request<LoginResult>({
    url: '/api/login',
    method: 'post',
    data
  })
}
export const getAuthList = () => {
  return request<Menu[]>({
    url: '/api/auth'
  })
}