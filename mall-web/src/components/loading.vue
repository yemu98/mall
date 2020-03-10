<template>
<el-col class="loadingWrap" v-loading="loading">
    <p class="loadingText">{{text}}</p>
</el-col>
</template>
<script>
export default {
    name: 'loading',
    props: {
        loading: {
            default () {
                return false
            }
        },
        text: {
            default () {
                return '加载中...'
            }
        }
    },
    data () {
        return{
        }
    }
}
</script>
<style scoped>
.loadingWrap{
    height: 50px;
    border-radius: 5px;
    background-color: rgba(194, 193, 193, 0.1);
}
.loadingText{
    opacity: 0.5;
}
</style>