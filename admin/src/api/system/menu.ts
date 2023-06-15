import request from '@/utils/request'
import {Menu, MenuForm} from '@/types/system/menu'
export const getMenuList = () => {
  return request<Menu[]>({
    url: '/api/menu/list',
    hideLoading: true
  })
}

export const addMenu = (data: MenuForm) => {
  return request({
    url: '/api/menu/add',
    method: 'post',
    data
  })
}

export const delMenu = (id:string) => {
  return request({
    url: `/api/menu/delete/${id}`
  })
}

export const updateMenu = (data: MenuForm) => {
  return request({
    url: '/api/menu/update',
    method: 'post',
    data
  })
}

export const getMenuDetail = (id:string) => {
  return request<Menu>({
    url: `/api/menu/detail/${id}`
  })
}