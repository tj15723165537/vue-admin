import request from '@/utils/request'
import {User} from '@/types/system/user'

export const getUserList = (data: object) => {
  return request<ResultData<User>>({
    url: '/api/user/list',
    data,
    hideLoading: true
  })
}

export const addUser = (data: User) => {
  return request({
    url: '/api/user/add',
    method: 'post',
    data
  })
}

export const editUser = (data: User) => {
  return request({
    url: '/api/user/update',
    method: 'post',
    data
  })
}

export const getUserDetail = (id: number) => {
  return request<User>({
    url: `/api/user/detail/${id}`
  })
}

export const delUser = (id: number) => {
  return request({
    url: `/api/user/delete/${id}`
  })
}

export const updateUserStatus = (id: number) => {
  return request({
    url: `/api/user/updateStatus/${id}`
  })
}
