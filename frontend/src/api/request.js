import axios from 'axios'

// 统一的 Axios 请求封装：后续实验可在此统一携带 Token、处理错误码
const request = axios.create({
  baseURL: '/api',
  timeout: 5000
})

request.interceptors.response.use(
  (response) => response.data,
  (error) => Promise.reject(error)
)

export default request
