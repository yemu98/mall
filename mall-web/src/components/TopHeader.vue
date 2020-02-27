<template>
  <el-menu
    :default-active="activedMenu($route.path)"
    mode="horizontal"
    @select="handleMenuSelect"
    menu-trigger="click"
  >
    <el-menu-item index="/">
      <img src="../assets/logo.png" style="width: 50px;" />
    </el-menu-item>
    <el-menu-item index="login" v-show="!isLogin">登录</el-menu-item>
    <el-menu-item index="register" v-show="!isLogin">注册</el-menu-item>
    <el-submenu index="profile" v-if="isLogin">
      <template slot="title">
        <i class="el-icon-user-solid"></i>个人中心
      </template>
      <el-menu-item index="myOrder">
        <i class="el-icon-s-order"></i>我的订单
      </el-menu-item>
      <el-menu-item index="cart">
        <i class="el-icon-shopping-cart-full"></i>购物车
      </el-menu-item>
      <el-menu-item v-if="isLogin" v-on:click="logout">
        <i class="el-icon-circle-close" />退出
      </el-menu-item>
    </el-submenu>
    <div class="searchWrap">
      <el-autocomplete
        v-model="searchContent"
        :fetch-suggestions="querySearchAsync"
        placeholder="请输入内容"
        @select="handleSuggestionSelect"
        class="search"
        @keyup.enter.native="searchSubmit"
      >
        <i slot="prefix" class="el-input__icon el-icon-search"></i>
      </el-autocomplete>
    </div>
  </el-menu>
</template>

<style scoped>
.el-row {
  width: 100%;
}
.el-menu-item {
  border-block: 1px;
  border-block-color: black;
  margin-left: 0;
}
.search {
  line-height: 60px;
}
</style>

<script>
export default {
  data: function () {
    return {
      activeIndex: '1',
      logourl: require('../assets/logo.png'),
      isLogin: false,
      searchContent: '',
      suggestions: [{
        'value': 'test'
      }]
    }
  },
  methods: {
    handleMenuSelect (key) {
      this.$router.push({ path: key })
    },
    logout () {
      window.localStorage.removeItem('token')
      this.$router.push("/")
      this.$router.go(0)
    },
    activedMenu (val) {
      if (val.indexOf('/register') == 0) {
        return 'register'
      }
      if (val.indexOf('/login') == 0) {
        return 'login'
      }
    },
    querySearchAsync (queryString, callback) {
      let suggestions = this.suggestions
      let results = queryString ? suggestions.filter(this.createStateFilter(queryString)) : suggestions
      callback(results)
    },
    createStateFilter (queryString) {
      return (state) => {
        return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
      }
    },
    handleSuggestionSelect (item) {
      console.log(item);
      this.searchContent = item.value
      this.searchSubmit()
    },
    searchSubmit () {
      this.$router.push({ path: '/search', query: { searchContent: this.searchContent } })
    },
    getUid () {
      this.$axios.get("/getId",
        {
          headers: {
            'token': window.localStorage.getItem('token')
          }
        }).then((res) => {
          if (res.data.data != null) {
            let uid = res.data.data.uid
            this.$store.state.uid = uid
            this.isLogin = true
          } else {
            this.isLogin = false
          }
        })
    }
  },
  mounted: function () {
    let token = window.localStorage.getItem('token')
    if (token == null || token == '' || token == undefined) {
      this.isLogin = false
    }
    else {
      this.getUid()
    }
  }
}
</script>
