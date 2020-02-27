import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    uid: '',
    searchContent: '',
    isLogin: false
  },
  mutations: {
  },
  actions: {
    getUid () {
      let token = window.localStorage.getItem('token')
      if (token == null || token == '' || token == undefined) {
        this.isLogin = false
      }
      else {
        axios.get("/getId",
        {
          headers: {
            'token': window.localStorage.getItem('token')
          }
        }).then((res) => {
          if (res.data.data != null) {
            let uid = res.data.data.uid
            this.uid = uid
            this.isLogin = true
          } else {
            this.isLogin = false
          }
        })
      }
    }
  },
  modules: {
  }
})
