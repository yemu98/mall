<template>
  <el-card shadow="hover" :body-style="{ padding: '20px' }">
    <el-row class="card-header">
      <p style="display:none">{{product.id}}</p>
      <el-button class="unLikeBtn" @click="unLike(product.id)" type="text" title="不喜欢">
        <i class="el-icon-close"></i>
      </el-button>
    </el-row>
    <router-link :to="{path: '/item',query: {id:product.id}}" @click.native="click(product.id)">
    <el-row class="card-img">
      <el-image :src="imgUrl" class="image" fit="scale-down" lazy>
        <div slot="error" class="image-slot">
          <span>加载失败</span>
        </div>
      </el-image>
    </el-row>
    <el-row class="card-name">
      <span class="name">{{product.name}}</span>
    </el-row>
    <el-row class="card-info">
      <span class="info">{{product.info}}</span>
    </el-row>
    <el-row class="card-price">
      <p class="price">￥{{product.price}}</p>
    </el-row>
      </router-link>
  </el-card>

</template>

<script>
export default {
  props: {
    product: {
      type: Object
    },
    imgUrl: {
      type: String,
      default () {
      }
    }
  },
  data () {
    return {
    }
  },
  methods: {
    unLike (pid) {
      this.$emit('unlike', '')// 让父组件删除此组件
      let uid = this.$store.state.uid
      let data = this.qs.stringify({
        uid: uid,
        pid: pid
      })
      this.$axios.post("/user/unlike/add",data).then((res) => {
        console.log(res)
      })
    },
    click (pid) {
      let uid = this.$store.state.uid
      let data =this.qs.stringify({
        uid: uid,
        pid: pid
      })
      this.$axios.post("/user/history/click/add",data).then((res) => {
        console.log(res)
      })
    }
  }
}
</script>

<style>
.el-card:hover {
  transform: translate(0px, -3px);
  box-shadow: 0px 5px 5px 5px rgba(0, 0, 0, 1);
}
.el-card {
  padding: 0;
  height: 300px;
  width: 180px;
  border-radius: 5px;
}
a{
  text-decoration: none
}
.card-img {
  display: block;
  height: 140px;
  width: 140px;
}
.image-slot {
  display: inline-block;
  width: 100%;
  line-height: 150px;
  border-radius: 5px;
  color: #999;
  font-weight: 100;
  background-color: rgba(214, 214, 214, 0.3);
}
.card-header {
  width: 100%;
  height: 10px;
}

.card-name {
  height: 20px;
  color: rgb(105, 105, 105);
  overflow: hidden;
}
.card-info {
  height: 50px;
  overflow: hidden;
}
.card-price {
  height: 40px;
  overflow: hidden;
}
.unLikeBtn {
  color: rgba(0, 0, 0, 0.5);
  display: none;
  float: right;
  margin: 0px auto;
  margin-top: -26px;
  margin-right: -16px;
}
.unLikeBtn:hover {
  background-color: rgb(161, 11, 11);
  color: white;
}
.el-card:hover .unLikeBtn {
  display: block;
  width: 16px;
  height: 16px;
}
.image {
  width: 100%;
  height: 100%;
  display: block;
}
.info {
  overflow: hidden;
  font-size: 13px;
  color: #999;
  word-break: break-all;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  text-overflow: ellipsis;
}
.name {
  overflow: hidden;
  font-size: 15px;
  word-break: break-all;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
  text-overflow: ellipsis;
}
.price {
  color: rgb(223, 7, 7);
  font-weight: bold;
}
</style>
