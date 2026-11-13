import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// Vue 开发服务器：5173 端口，将 /api 请求代理到 SpringBoot 后端
export default defineConfig({
  plugins: [vue()],
  server: {
    port: 5173,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true
      }
    }
  }
})
