<template>
  <div id="app" ref="homePage">
    <el-container>
      <el-header :style="{padding: 0}" v-if="updateHeader">
        <topHeader ref="header" />
      </el-header>
      <el-main>
        <el-col :span="20" :offset="2">
          <router-view />
        </el-col>
      </el-main>
      <el-footer :style="{padding: 0}">
        <mallFooter/>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
export default {
  name: 'App',
  // 暴露方法（刷新导航栏）
  provide () {
    return {
      refreshHeader: this.refreshHeader
    }
  },
  data () {
    return {
      minHeight: 0,
      updateHeader: true
    }
  },
  methods: {
    refreshHeader () {
      this.updateHeader = false
      this.$nextTick(() => (this.updateHeader = true
      ))
    }
  }
}

</script>

<style>
#app {
  background-color: #f5f5f5;
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB",
    "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
  min-width: 1366px;
}
.el-main{
  min-height: calc(100vh - 120px)
}

</style>
