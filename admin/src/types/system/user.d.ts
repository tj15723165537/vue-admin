interface User {
    id: number | string
    account: string
    password: string
    status: 0 | 1 | boolean
    createAt: Date
    updateAt: Date
}

interface UserPageParams extends PageParams {
    account?: string
    status?: 0 | 1
}