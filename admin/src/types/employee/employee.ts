export interface Employee {
  id: string | number
  name: string
  phone: string
  date: Date | string
  address: string
}

export interface EmployeeSearch extends PageParams {
  name?: string
  phone?: string
  address?: string
}

export interface EmployeeForm {
  id?: string | number | null
  name: string
  phone: string
  date: Date | string
  address: string
}