<template>
  <div>
    <el-row>
      <el-col :span="4" v-for="(card,index) in cards" :key="index">
        <goodsCard @unlike="delete_card(index)" :product="card.product" :imgUrl="card.imgUrl"></goodsCard>
      </el-col>
    </el-row>
    <el-backtop></el-backtop>
  </div>
</template>

<script>
export default {
  name: 'searchRelut',
  data () {
    return {
      cards: []
    }
  },
  methods: {
    addCard (searchContent) {
      this.cards = []
      this.$axios({
        method: 'get',
        url: '/product/search',
        params: {
          searchContent: searchContent
        }
      }).then((res) => {
        console.log(res)
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
    }
  },
  mounted: function () {
    this.addCard(this.$route.query.searchContent)
  },
  watch: {
    '$route' (){
      this.addCard(this.$route.query.searchContent)
    }
  }
}
</script>

<style>
</style>