<template>

    <div class="v-g-item">

<el-card :body-style="{ padding: '0px'}" id="goods-card">
<slot name="v-g-img"></slot>

<div style="padding: 14px">

<span style="font-weight: 700; word-break: break-all; word-wrap: break-word; display: block;" ><slot name="v-g-name" ></slot></span>

<div class="bottom" style="width:100% ;height:4vw;">
<el-button text class="button" style="margin-left:3px" @click="this.$router.push('/goodsinfo')">详情</el-button>
</div>
</div>
</el-card>

</div>
</template>

<script>
export default {

}
</script>

<style>
.v-g-item{
    margin-bottom: 2vw;
}
#goods-card{
    width:18vw;
    /* min-width:240px;
    min-height:400px; */
    height:35vw;
}
</style>