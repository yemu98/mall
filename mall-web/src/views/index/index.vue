<template>
  <div >
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="item in 4" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <el-button v-on:click="addCard()">添加</el-button>
    <el-row>
      <el-col :span="4" v-for="(card,index) in cards" :key="index">
        <goodsCard @unlike="delete_card(index)" :product="card.product" :imgUrl="card.imgUrl"></goodsCard>
      </el-col>
    </el-row>
    <el-backtop></el-backtop>
  </div>
  
</template>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>

<script>
export default {
  data () {
    return {
      cards: []
    }
  },
  methods: {
    addCard () {
      this.$axios({
        method: 'get',
        url: '/product/getByUser',
        params: {
          'uid': this.uid
        }
      }).then((res) => {
        var productlist = []
        productlist = res.data.data.productList
        productlist.forEach(element => {
          var product = element.product
          var imgs = element.imgList
          var card = {}
          if (imgs[0] !== undefined) {
            var imgUrl = imgs[0].url
            card.product = product
            card.imgUrl = imgUrl
          }
          else {
            card.product = product
          }
          this.cards.push(card)
        })
      })
    },
    delete_card (index) {
      this.cards.splice(index, 1)
    },
    scrollLoad () {
      let isLoading = false
      // 距离200px时加载一次
      window.onscroll = () => {
        let bottomOfWindow  = document.documentElement.offsetHeight - document.documentElement.scrollTop - window.innerHeight <= 200
        if (bottomOfWindow && !isLoading){
          isLoading = true
        }
      }
    }
  },
  mounted: function () {
    this.addCard()
    // 添加滚动事件
    this.scrollLoad()
  },
  created () {
    this.uid = this.$store.state.uid
  }
}
</script>
