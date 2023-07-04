import request from '@/utils/request'
import {User} from '@/types/system/user'
import { RoleVO } from '@/types/system/role'

export const getRoleList = (data: object) => {
  return request<ResultData<RoleVO>>({
    url: '/api/role/list',
    data,
    hideLoading: true
  })
}

export const addRole = (data: User) => {
  return request({
    url: '/api/role/add',
    method: 'post',
    data
  })
}

// export const editUser = (data: User) => {
//   return request({
//     url: '/api/user/update',
//     method: 'post',
//     data
//   })
// }
//
// export const getUserDetail = (id: number) => {
//   return request<User>({
//     url: `/api/user/detail/${id}`
//   })
// }
//
// export const delUser = (id: number) => {
//   return request({
//     url: `/api/user/delete/${id}`
//   })
// }
//
// export const updateUserStatus = (id: number) => {
//   return request({
//     url: `/api/user/updateStatus/${id}`
//   })
// }
