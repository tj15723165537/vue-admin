import request from '@/utils/request'
import {Menu, MenuForm} from '@/types/system/menu'
export const getMenuList = () => {
  return request<Menu[]>({
    url: '/api/menu/list'
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