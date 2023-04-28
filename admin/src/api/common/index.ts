import requset from '@/utils/request'

export const login = (data: object) => {
  return requset<any>({
    url: '/api/login',
    method: 'post',
    data
  })
}
