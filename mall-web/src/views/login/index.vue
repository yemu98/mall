<template>
  <el-col :span="8" :offset="8" class="login">
    <el-row>
      <el-col>
        <router-link to="/index">
          <img :src="logourl" style="width: 50px;" />
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-input placeholder="*请输入手机号" v-model="account" clearable></el-input>
        <el-alert v-if="account_tips" title="请输入账号！" type="error" show-icon></el-alert>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-input
          placeholder="*请输入密码"
          v-model="password"
          clearable
          @keyup.enter.native="login"
          show-password
          autocomplete="new-password"
        ></el-input>
        <el-alert v-if="pwd_tips" title="请输入密码！" type="error" show-icon></el-alert>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <router-link to="register">
          <el-link>立即注册</el-link>
        </router-link>|
        <router-link to="forgetPwd">
          <el-link>忘记密码？</el-link>
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col>
        <el-button
          ref="login_btn"
          type="primary"
          style="width:100%"
          v-on:click="login"
          :loading="loading"
        >登录</el-button>
      </el-col>
    </el-row>
  </el-col>
</template>

<style>
.login {
  margin-top: 5rem;
  background-color: white;
  border-radius: 3%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5), 0 0 6px rgba(0, 0, 0, 0.04);
}
.el-col {
  padding: 0.6em;
}
a {
  text-decoration: none;
}
.router-link-active {
  text-decoration: none;
}
</style>

<script>
export default {
  name: 'login',
  // 注入方法
  inject: ['refreshHeader'],
  data () {
    return {
      msg: 'hello',
      account: '',
      password: '',
      logourl: require('../../assets/logo.png'),
      loading: false,
      account_tips: false,
      pwd_tips: false
    }
  },
  methods: {
    login: function () {
      this.loading = true
      this.account_tips = false
      this.pwd_tips = false
      if (this.account.split(' ').join('').length === 0) {
        this.account_tips = true
        this.loading = false
        return
      }
      if (this.password.split(' ').join('').length === 0) {
        this.pwd_tips = true
        this.loading = false
        return
      }
      // Axios向后端提交数据容易接收不到原因是传参方式是request payload,参数格式是json，而并非用的是form传参
      // 拼成一个对象
      let user = this.qs.stringify({
        phone: this.account,
        pwd: this.password
      })
      this.$axios({
        method: 'post',
        url: '/login',
        data: user
      }).then((res) => {
        this.loading = false
        if (res.data.status === 0) {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'success'
          })
          var json = JSON.parse(JSON.stringify(res.data))
          window.localStorage.setItem('token', json.data)
          this.$router.push('/')
          this.refreshHeader()
          // this.$router.go(0)
        } else {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'error'
          })
        }
      })
        .catch((err) => {
          console.log(err)
          this.$message({
            showClose: true,
            message: '网络连接失败',
            type: 'error',
            offset: 30
          })
          this.loading = false
        })
    }
  }
}
</script>
