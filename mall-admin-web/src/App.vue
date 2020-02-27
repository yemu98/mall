<template>
  <div id="app">
    <router-view />
  </div>
</template>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  width: 100%;
  height: 100%;
}
html,
body{
  height: 100%;
  width: 100%;
  font-family: Helvetica Neue, Helvetica, PingFang SC, Hiragino Sans GB,
    Microsoft YaHei, Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: white;
}
.el-scrollbar__wrap{
  overflow-x: hidden;
}


</style>
<script>
export default {
  name: 'App'
}
</script>
