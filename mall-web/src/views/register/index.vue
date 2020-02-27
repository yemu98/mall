/** 注册 */
<template>
  <el-col :span="8" :offset="8" class="register">
    <el-row>
      <el-col>
        <router-link to="/index">
          <img :src="logourl" style="width: 50px" />
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col :pull="2">
        <el-form
          :model="user"
          status-icon
          :rules="rules"
          ref="user"
          label-width="100px"
          class="register_form"
        >
          <el-form-item label="手机号" prop="phone">
            <el-input type="phone" v-model="user.phone" autocomplete="off" placeholder="*请输入手机号"></el-input>
          </el-form-item>
          <el-form-item label="名字" prop="name">
            <el-input type="text" v-model="user.name" autocomplete="off" placeholder="*请输入名字"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="pwd">
            <el-input
              type="password"
              v-model="user.pwd"
              autocomplete="new-password"
              placeholder="*请输入密码"
              show-password
            ></el-input>
          </el-form-item>
          <el-form-item label="确认密码" prop="pwd2">
            <el-input
              type="password"
              v-model="user.pwd2"
              autocomplete="off"
              placeholder="*请再次确认密码"
              show-password
              @keyup.enter.native="submitForm('user')"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm('user')" :loading="loading">注册</el-button>
            <el-button @click="resetForm('user')">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </el-col>
</template>

<script>
export default {
  data () {
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('手机号不能为空'))
      }
      if (!(/^1[3456789]\d{9}$/.test(value))) {
        return callback(new Error('手机号格式错误'))
      }
      this.$axios({
        methods: 'get',
        url: '/user/existByPhone',
        params: {
          'phone': this.user.phone
        }
      }).then((res) => {
        if (res.data.data.exist) {
          return callback(new Error('该手机号已被注册'))
        } else {
          callback()
        }
      })
    }
    var checkName = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('名字不能为空'))
      }
      callback()
    }
    var checkPwd = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('密码不能为空'))
      }
      var patrn = /^(\w){6,20}$/
      if (!patrn.exec(value)) {
        return callback(new Error('只能输入6-20个字母、数字、下划线'))
      }
      callback()
    }
    var checkPwd2 = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('密码不能为空'))
      }
      var patrn = /^(\w){6,20}$/
      if (!patrn.exec(value)) {
        return callback(new Error('只能输入6-20个字母、数字、下划线'))
      }
      if (value !== this.user.pwd) {
        return callback(new Error('两次密码输入不一致'))
      }
      callback()
    }
    return {
      logourl: require('../../assets/logo.png'),
      user: {
        phone: '',
        name: '',
        pwd: '',
        pwd2: ''
      },
      rules: {
        phone: [
          { validator: checkPhone, trigger: 'blur' }
        ],
        name: [
          { validator: checkName, trigger: 'blur' }
        ],
        pwd: [
          { validator: checkPwd, trigger: 'blur' }
        ],
        pwd2: [
          { validator: checkPwd2, trigger: 'blur' }
        ]
      },
      loading: false
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.loading = true
          this.register()
        } else {
          console.log('error submit')
          return false
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    },
    register () {
      // 拼成一个formdata对象，因为传参方式是request payload,参数格式是json
      let user = this.qs.stringify(this.user)
      this.$axios({
        method: 'post',
        url: '/register',
        data: user
      }).then((res) => {
        this.loading = false
        if (res.data.status === 0) {
          this.$message({
            showClose: true,
            message: res.data.message,
            type: 'success'
          })
          setTimeout(() => {
            this.$router.push('/login')
          }, 1000)
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

<style scoped>
.register {
  background-color: white;
  border-radius: 3%;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5), 0 0 6px rgba(0, 0, 0, 0.04);
  overflow: hidden;
  padding: 20px;
}
.register_form {
  padding: 1rem;
}
</style>
