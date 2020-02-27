<template>
  <el-container class="app_wrap">
    <sidebar></sidebar>
    <el-container class="main_wrap" :class="{isCollapse: this.$store.state.isCollapse}">
      <navbar></navbar>
      <el-main><router-view :key="key"/></el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src
import sidebar from './components/sidebar'
import navbar from './components/navbar'
export default {
  name: 'Home',
  components: {
    sidebar,
    navbar
  },
  computed: {
    key() {
      return this.$route.path
    }
  },
  data () {
    return {
    }
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style>
.main_wrap{
  min-height: 100%;
  margin-left: 210px;
  transition: margin-left .3s;
}
.el-main {
  background-color: aliceblue;
}
.isCollapse{
  margin-left: 60px;
}
.sidebar{
  position: fixed;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 210px;
}

</style>
