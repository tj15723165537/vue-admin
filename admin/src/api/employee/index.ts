import { Employee, EmployeeForm } from '@/types/employee/employee'
import { UserSearch } from '@/types/system/user'
import request from '@/utils/request'

export const getEmployeeList = (data: UserSearch) => {
  return request<ResultData<Employee>>({
    url: '/api/employee/list',
    data,
    hideLoading: true
  })
}

export const addEmployee = (data: EmployeeForm) => {
  return request({
    url: '/api/employee/add',
    method: 'post',
    data
  })
}

export const editEmployee = (data: EmployeeForm) => {
  return request({
    url: '/api/employee/update',
    method: 'post',
    data
  })
}

export const getEmployeeDetail = (id: number) => {
  return request<Employee>({
    url: `/api/employee/getEmployeeById/${id}`
  })
}

export const delEmployee = (id: number) => {
  return request({
    url: `/api/employee/delete/${id}`
  })
}
