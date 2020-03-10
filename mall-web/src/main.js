// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 导入axios组件
import axios from 'axios'
import qs from 'qs'
import App from './App'
import router from './router'
import TopHeader from './components/TopHeader.vue'
import MallFooter from './components/MallFooter.vue'
import goodsCard from './components/goodsCard.vue'
import store from './store'


Vue.config.productionTip = false
Vue.use(ElementUI)
// 全局注册axios
Vue.prototype.$axios = axios
Vue.prototype.qs = qs
// 全局注册组件
Vue.component('topHeader', TopHeader)
Vue.component('mallFooter', MallFooter)
Vue.component('goodsCard', goodsCard)

// 接口根地址
axios.defaults.baseURL = 'http://127.0.0.1:8081'

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

// 添加axios拦截器 让请求时在header中带上token
axios.interceptors.request.use(
  config => {
    // 判断是否存在token
    if (localStorage.token!=null) {  
      // 从localStorage取token放入请求头
      config.headers.token = localStorage.token 
    }
    return config;
  },
  err => {
    return Promise.reject(err);
  })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  store,
  template: '<App/>'
})
