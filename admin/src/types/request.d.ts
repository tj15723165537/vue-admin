interface PageParams {
  page: number
  size: number
}

interface RequestOption {
  url: string
  method?: string
  data?: object
  hideLoading?: boolean
}

interface Response<T> {
  code: number
  data: T
  msg?: string
}

interface ResultData<T> {
  content: T[]
  total?: number
}
