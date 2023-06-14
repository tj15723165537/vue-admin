import { Employee, EmployeeForm } from '@/types/employee/employee'
import { UserSearch } from '@/types/system/user'
import requset from '@/utils/request'

export const getEmployeeList = (data: UserSearch) => {
  return requset<ResultData<Employee>>({
    url: '/api/employee/list',
    data
  })
}

export const addEmployee = (data: EmployeeForm) => {
  return requset({
    url: '/api/employee/add',
    method: 'post',
    data
  })
}

export const editEmployee = (data: EmployeeForm) => {
  return requset({
    url: '/api/employee/update',
    method: 'post',
    data
  })
}

export const getEmployeeDetail = (id: number) => {
  return requset<Employee>({
    url: `/api/employee/getEmployeeById/${id}`,
    data: {}
  })
}

export const delEmployee = (id: number) => {
  return requset({
    url: `/api/employee/delete/${id}`,
    data: {}
  })
}
