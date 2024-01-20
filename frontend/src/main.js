// src/main.js
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'  // Vue Router 추가

createApp(App)
  .use(router)  // Vue Router 적용
  .mount('#app')
