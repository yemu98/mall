<template>
  <el-header style="padding:0" height="50px">
    <el-row type="flex">
      <div class="flod-btn" @click="flod">
        <i v-show="!isCollapse" class="el-icon-s-fold"></i>
        <i v-show="isCollapse" class="el-icon-s-unfold"></i>
      </div>
      <div>
        <el-breadcrumb separator="/" class="breadcrumb">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{ path: '/index' }">活动管理</el-breadcrumb-item>
          <el-breadcrumb-item>活动列表</el-breadcrumb-item>
          <el-breadcrumb-item>活动详情</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-row>
  </el-header>
</template>

<script>
export default {
  name: 'navbar',
  data () {
    return {
    }

  },
    computed: {
    isCollapse: function() {
      return this.$store.state.isCollapse
    }
  },
  methods: {
    flod () {
      this.$store.state.isCollapse = !this.isCollapse
    }
  }
}
</script>

<style scoped>
.flod-btn {
  display: inline-block;
  vertical-align: middle;
  width: 16px;
  height: 100%;
  padding: 0 15px;
  line-height: 50px;
}
.flod-btn:hover {
  background: rgba(0, 0, 0, 0.05);
}
.breadcrumb{
  vertical-align: middle;
  display: inline-block;
  line-height: 50px;
}
</style>