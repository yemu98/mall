/**商品详情 */
<template>
    <div>
        <div class="item-intro-wrap">
            <!-- <img src="../../assets/logo.png"/> -->
                <item-preview></item-preview>
                <item-info></item-info>
        </div>
        <div class="item-detail-wrap">
            <item-deatil></item-deatil>
        </div>
    </div>
</template>

<script>   
import itemPreview from './itemPreview'
import itemInfo from './itemInfo'
import itemDeatil from './itemDeatil';
export default {
    name: 'item',
    data () {
        return {

        }
    },
    components:{
        'item-preview': itemPreview,
        'item-info': itemInfo,
        'item-deatil': itemDeatil

    }
}
</script>

<style>
.item-intro-wrap{
    display: block;
    width: 400px;
    height: 400px;
    border:1px solid black;
}
.item-deatil-wrap{
    border:1px solid black;
}
</style>