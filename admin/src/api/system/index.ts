import requset from '@/utils/request'
import { RouteRecordRaw } from 'vue-router'

export const getMenuList = (data: object) => {
  return requset<RouteRecordRaw[]>({
    url: '/api/menu/list',
    data
  })
}

export const getUserList = (data: object) => {
  return requset<ResultData<User>>({
    url: '/api/user/list',
    data
  })
}

export const addUser = (data: User) => {
  return requset({
    url: '/api/user/add',
    method: 'post',
    data
  })
}

export const editUser = (data: User) => {
  return requset({
    url: '/api/user/update',
    method: 'post',
    data
  })
}

export const getUserDetail = (id: number) => {
  return requset<User>({
    url: `/api/user/detail/${id}`,
    data: {
    }
  })
}

export const delUser = (id: number) => {
  return requset({
    url: `/api/user/delete/${id}`,
    data: {
    }
  })
}

export const updateUserStatus = (id: number) => {
  return requset({
    url: `/api/user/updateStatus/${id}`,
    data: {
    }
  })
}
