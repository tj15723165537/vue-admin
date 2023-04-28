interface Employee {
    id: string | number
    name: string
    phone: string
    date: Date | string
    address: string
}

interface EmployeePageParams extends PageParams {
    name?: string
    phone?: string
    address?: string
}

interface EmployeeCU {
    id?: string | number | null
    name: string
    phone: string
    date: Date | string
    address: string
}