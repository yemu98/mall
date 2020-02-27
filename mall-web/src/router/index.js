import Vue from 'vue'
import Router from 'vue-router'
import goodsCard from '@/components/goodsCard'
import error from '../views/404.vue'
import search from '../views/search'

Vue.use(Router)

// 解决路由重复点击控制台报错(NavigationDuplicated vue-router)问题
const originalPush = Router.prototype.push
Router.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

export default new Router({
  routes: [
    {
      
      path: '/',
      name: '首页',
      component: () => import('../views/index'),
      meta: {
        title: '首页'
      }

    },
    {
      path: '/index',
      name: 'index',
      component: () => import('../views/index'),
      meta: {
        title: '首页'
      }

    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login'),
      meta: {
        title: '登录'
      }
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('../views/register'),
      meta: {
        title: '注册'
      }
    },
    {
      path: '/card',
      name: 'card',
      component: goodsCard,
      meta: {
        title: '商品卡片'
      }
    },
    {
      path: '*/',
      name: '404',
      component: error,
      meta: {
        title: '404'
      }
    },
    {
      path: '/search',
      name: '搜索',
      component: search,
      meta: {
        title: '搜索'
      }
    },
    {
      path: '/item',
      name: '商品详情',
      component: () => import('../views/item'),
      meta: {
        title: '搜索'
      }
    },
  ]
  
})
