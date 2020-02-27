<template>
  <el-aside width="auto" class="sidebar">
    <el-scrollbar style="height:100%">
      <el-menu
        default-active="1"
        class="el-menu-vertical"
        @open="handleOpen"
        @close="handleClose"
        :collapse="isCollapse"
        background-color="#304156"
        text-color="#fff"
        active-text-color="#ffd04b"
        :router="true"
      >
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span slot="title">导航一</span>
          </template>
          <el-menu-item-group>
            <span slot="title">分组一</span>
            <el-menu-item index="1-1">选项1</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <span slot="title">选项4</span>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-submenu index="product">
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span slot="title">商品管理</span>
          </template>
          <el-menu-item index="/product/add">添加商品</el-menu-item>
        </el-submenu>
        <el-menu-item index="/product/index">
          <i class="el-icon-menu"></i>
          <span slot="title">商品管理</span>
        </el-menu-item>
        <el-menu-item index="3" disabled>
          <i class="el-icon-document"></i>
          <span slot="title">导航三</span>
        </el-menu-item>
        <el-menu-item index="4">
          <i class="el-icon-setting"></i>
          <span slot="title">导航四</span>
        </el-menu-item>
      </el-menu>
    </el-scrollbar>
  </el-aside>
</template>

<script>
export default {
  name: 'sidebar',
  components: {
  },
  data () {
    return {

    };
  },
  computed: {
    isCollapse: function () {
      return this.$store.state.isCollapse
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
.el-menu-vertical{
    width: 210px;
}
.el-menu-vertical:not(.el-menu--collapse) {
  width: 210px;
}
.sidebar {
  background-color: #304156;
  height: 100%;
  font-size: 0;
  top: 0;
  bottom: 0;
  left: 0;
  z-index: 1001;
  scrollbar-width: none;
  overflow: hidden;

}
.sidebar:not(.el-menu--collapse) {
  width: 210px;
}
</style>