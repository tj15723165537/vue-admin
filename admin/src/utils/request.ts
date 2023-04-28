import axios from 'axios'
import {ElMessage} from 'element-plus'
import {useCommonStore} from '@/store/modules/common'
import {router} from '@/router/index'

const store = useCommonStore()
const instance = axios.create({
  timeout: 10000
})

instance.interceptors.request.use((request) => {
  if (store.token) {
    request.headers!['authorization'] = store.token
  }
  return request
})
instance.interceptors.response.use(
  (response) => {
    return response
  },
  (error) => {
    ElMessage.warning('服务器连接失败,错误信息: ' + error.message)
  }
)

const request = <T>(option: RequestOption): Promise<Response<T>> => {
  return new Promise((resolve, reject) => {
    const { url, method, data } = option
    instance({
      url,
      method,
      params: method?.toLowerCase() === 'post' ? null : data,
      data: method?.toLowerCase() === 'post' ? data : null
    })
      .then((res) => {
        if (res.status !== 200) {
          const errMsg = '网络错误'
          ElMessage.error(errMsg)
          reject(errMsg)
        } else {
          if (res.data.code !== 200) {
            if (res.data.code === 401) {
              router.push('/login')
            }
            const errMsg = res.data.msg || res.data.message || '意料之外的错误'
            return ElMessage.error(errMsg)
            reject(errMsg)
          }
          resolve(res.data)
        }
      })
      .catch((err) => {
        reject(err)
      })
  })
}
export default request
