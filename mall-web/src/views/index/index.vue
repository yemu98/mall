<template>
  <div >
    <el-carousel indicator-position="outside">
      <el-carousel-item v-for="item in 4" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
    <el-row>
      <el-col :span="4" v-for="(card,index) in cards" :key="index" class="goods_wrap">
        <goodsCard @unlike="delete_card(index)" :product="card.product" :imgUrl="card.imgUrl"></goodsCard>
      </el-col>
      <loading :loading="this.$store.state.goodCardLoading" :text="loadingText"></loading>
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
  .goods_wrap{
    padding: 5px;
  }
</style>
<script>
import loading from '../../components/loading'
export default {
  data () {
    return {
      cards: [],
      loadingText: '加载中'
    }
  },
  components: {
    'loading': loading
  },
  methods: {
    addCard () {
      this.$axios({
        method: 'get',
        url: '/product/getByUser',
        params: {
          'uid': this.uid,
          'pageNo': this.$store.state.pageNo,
          'pageSize': this.$store.state.pageSize
        }
      }).then((res) => {
        var productlist = []
        productlist = res.data.data.productList
        if (productlist.length<1){
          this.$store.state.goodCardLoading = false
          this.loadingText = '人家也是有底线的~~'
          return
        }
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
        this.$store.state.pageNo++
        this.$store.state.goodCardLoading = false
      })
    },
    delete_card (index) {
      this.cards.splice(index, 1)
    },
    scrollLoad () {
      // let isLoading = false
      // 距离200px时加载一次
      window.onscroll = () => {
        let bottomOfWindow  = document.documentElement.offsetHeight - document.documentElement.scrollTop - window.innerHeight <= 200
        if (bottomOfWindow && ! this.$store.state.goodCardLoading){
          this.$store.state.goodCardLoading = true
          this.addCard()
        }
      }
    }
  },
  mounted: function () {
    // 初始化页码
     this.$store.state.pageNo = 1
    this.addCard()
    // 添加滚动事件
    this.scrollLoad()
  },
  created () {
    this.uid = this.$store.state.uid
  }
}
</script>
