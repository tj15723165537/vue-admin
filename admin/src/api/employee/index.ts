import requset from '@/utils/request'

export const getEmployeeList = (data: UserPageParams) => {
  return requset<ResultData<Employee>>({
    url: '/api/employee/list',
    data
  })
}

export const addEmployee = (data: EmployeeCU) => {
  return requset({
    url: '/api/employee/add',
    method: 'post',
    data
  })
}

export const editEmployee = (data: EmployeeCU) => {
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
