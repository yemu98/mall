import Vue from 'vue'
import VueRouter from 'vue-router'
import layout from '../layout/'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'index',
    component: layout,
    meta: {
      title: '首页'
    }
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/product',
    component: layout,
    children: [
      {
        path: 'index',
        component: () => import('../views/product'),
        name: 'product',
        meta: { title: '商品管理' }
      },
      {
        path: 'add',
        component: () => import('../views/product/add.vue'),
        name: 'addproduct',
        meta: { title: '添加商品'}
      }
    ]

  }
]

const router = new VueRouter({
  routes
})

export default router
