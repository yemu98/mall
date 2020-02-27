import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css';
// 导入axios组件
import axios from 'axios'
import qs from 'qs'

// vue生产模式 开发模式切换
Vue.config.productionTip = true
Vue.use(ElementUI)
// 全局注册axios
Vue.prototype.$axios = axios
Vue.prototype.qs = qs
// 接口根地址
axios.defaults.baseURL = 'http://127.0.0.1:8082'
new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})