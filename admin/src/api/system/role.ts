import request from '@/utils/request'
import {User} from '@/types/system/user'
import {RoleMenuList, RoleVO} from '@/types/system/role'

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

export const editRole = (data: RoleVO) => {
  return request({
    url: '/api/role/update',
    method: 'post',
    data
  })
}

export const getRoleDetail = (id: number) => {
  return request<RoleVO>({
    url: `/api/role/detail/${id}`
  })
}

export const delRole = (id: string) => {
  return request({
    url: `/api/role/delete/${id}`
  })
}

export const assignRole = (data: { menuList: string[] }) => {
  return request({
    url: `/api/role/assign`,
    method: 'post',
    data
  })
}

export const getRoleMenuList = (id: string) => {
  return request<RoleMenuList>({
    url: `/api/role/roleMenuList/${id}`
  })
}