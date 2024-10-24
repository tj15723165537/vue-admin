import { Employee, EmployeeForm, EmployeeSearch } from "@/types/employee/employee"
import request from "@/utils/request"

export const getEmployeeList = (data: EmployeeSearch) => {
  return request<ResultData<Employee>>({
    url: "/api/employee/list",
    data,
    hideLoading: true,
  })
}

export const addEmployee = (data: EmployeeForm) => {
  return request({
    url: "/api/employee/add",
    method: "post",
    data,
  })
}

export const editEmployee = (data: EmployeeForm) => {
  return request({
    url: "/api/employee/update",
    method: "post",
    data,
  })
}

export const getEmployeeDetail = (id: string) => {
  return request<Employee>({
    url: `/api/employee/getEmployeeById/${id}`,
  })
}

export const delEmployee = (id: number) => {
  return request({
    url: `/api/employee/delete/${id}`,
  })
}
