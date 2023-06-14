import request from '@/utils/request'

export const login = (data: object) => {
  return request<any>({
    url: '/api/login',
    method: 'post',
    data
  })
}
