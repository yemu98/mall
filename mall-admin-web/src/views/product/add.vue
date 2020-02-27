<template>
  <el-form
    label-position="right"
    style="width:400px"
    label-width="80px"
    :model="product"
    :rules="rules"
    ref="product"
    status-icon
  >
    <el-form-item label="商品名" prop="name">
      <el-input v-model="product.name"></el-input>
    </el-form-item>
    <el-form-item label="品牌" prop="brand">
      <el-input v-model="product.brand"></el-input>
    </el-form-item>
    <el-form-item label="描述信息" prop="info">
      <el-input type="textarea" maxlength="40" :show-word-limit="true" v-model="product.info"></el-input>
    </el-form-item>
    <el-form-item label="价格" prop="price">
      <el-input v-model="product.price"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-cascader
        placeholder="试试搜索"
        :options="category"
        :props="{ checkStrictly: true }"
        clearable
        filterable
        value="product.category"
      ></el-cascader>
    </el-form-item>
    <el-form-item label="商品图片" prop="imgList">
      <el-upload
        action="http://127.0.0.1:8082/uploadImg"
        list-type="picture-card"
        name="img"
        accept="image/png, image/jpeg, image/jpg"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :on-error="handleError"
        :on-success="handleSuccess"
        :on-change="handleChange"
        :file-list="imgList"
      >
        <i class="el-icon-plus"></i>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过1M</div>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt />
      </el-dialog>
    </el-form-item>
    <el-form-item label="上架" prop="status">
      <el-switch v-model="product.status"></el-switch>
    </el-form-item>
    <el-form-item label="库存" prop="stock">
      <el-input type="number" v-model="product.stock"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm()" :loading="loading">完成</el-button>
      <el-button @click="resetForm('product')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data () {
    var checkPrice = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('价格不能为空'))
      }
      if (isNaN(value) || !isFinite(value)) {
        return callback(new Error('请输入合法数字'))
      }
      callback()
    }
    return {
      product: {
        name: '',
        brand: '',
        info: '',
        price: '',
        category: '',
        status: 'true',
        stock: ''
      },
      imgList: [],
      dialogImageUrl: '',
      dialogVisible: false,
      loading: false,
      category: [{
        value: 'zhinan',
        label: '指南',
        children: [{
          value: 'shejiyuanze',
          label: '设计原则',
          children: [{
            value: 'yizhi',
            label: '一致'
          }, {
            value: 'fankui',
            label: '反馈'
          }, {
            value: 'xiaolv',
            label: '效率'
          }, {
            value: 'kekong',
            label: '可控'
          }]
        }]
      }],
      rules: {
        price: [
          { validator: checkPrice, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleRemove (file, fileList) {
      // console.log(fileList)
      this.handleChange(file, fileList)//更新图片列表
    },
    handlePictureCardPreview (file) {
      console.log(file.url)
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    handleSuccess (res, file) {
      file.url = res.data.img.url// 修改文件信息
      file.id = res.data.img.id
      this.handleChange(file)
      // let img = {id: res.data.img.id,url: res.data.img.path}
      // fileList.push(img)//放入图片列表中
      // console.log(fileList)
    },
    handleError (err) {
      // err是个错误对象，带有错误码和载荷
      // 载荷是个json对象需要转换一下
      let res = JSON.parse(err.message)
      this.$message({
        showClose: true,
        message: res.message,
        type: 'error'
      })
    },
    handleChange (file, fileList) {
      // 同步图片列表
      this.imgList = fileList
    },
    submitForm () {
      this.loading = true
      let imgList = []
      for (let i = 0; i < this.imgList.length; i++) {
        let img = { id: this.imgList[i].id, name: this.imgList[i].name, url: this.imgList[i].url }
        imgList.push(img)
      }
      // let product = this.qs.stringify(this.product,{arrayFormat: 'indices', allowDots: true})
      let product = this.product
      console.log(product)
      this.$axios.post('/product/add', { "product": product, "imgList": imgList }).then((res) => {
        console.log(res)
        this.resetFields()
      })
    },
    resetForm (formName) {
      this.imgList = []
      this.$refs[formName].resetFields()
      console.log(this.$refs[formName])
    }
  }
}
</script>

<style>
</style>