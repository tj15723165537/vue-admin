import request from '@/utils/request'
import { LoginForm, LoginResult } from '@/types/common'

export const login = (data: LoginForm) => {
  return request<LoginResult>({
    url: '/api/login',
    method: 'post',
    data
  })
}
