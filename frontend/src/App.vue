<script setup>
import { onMounted, ref } from 'vue'
import request from './api/request'

const loading = ref(false)
const result = ref(null)
const error = ref('')

// 调用后端 /api/hello 接口，验证前后端分离链路是否打通
const loadHello = async () => {
  loading.value = true
  error.value = ''
  try {
    result.value = await request.get('/hello')
  } catch (e) {
    error.value = '后端接口调用失败，请确认 SpringBoot 服务已在 8080 端口启动'
  } finally {
    loading.value = false
  }
}

onMounted(loadHello)
</script>

<template>
  <main class="page">
    <section class="card">
      <p class="badge">SpringBoot + Vue 3 + Axios</p>
      <h1>医疗系统 Hello World</h1>
      <p class="subtitle">前后端分离初始化验证页面</p>

      <button :disabled="loading" @click="loadHello">
        {{ loading ? '正在调用后端接口...' : '调用后端接口' }}
      </button>

      <div v-if="result" class="result success">
        <p class="message">{{ result.message }}</p>
        <ul>
          <li><span>系统名称</span>{{ result.data.systemName }}</li>
          <li><span>项目版本</span>{{ result.data.version }}</li>
          <li><span>运行状态</span>{{ result.data.status }}</li>
        </ul>
      </div>

      <div v-if="error" class="result error">{{ error }}</div>
    </section>
  </main>
</template>
