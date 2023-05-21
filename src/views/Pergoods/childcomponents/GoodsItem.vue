<template>
  <div class="goods-item">
      <el-card class="box-card">
      <div class="goods-i-img">
        <slot name="g-img"></slot>
      </div>
      
       <div class="goods-name">
        <span class="name-t">商品名称：</span>
        <el-text tag="b"><slot name="g-name" ></slot> </el-text>
       </div>

      <div class="goods-price">
        <span class="price-t">商品价格：</span>
        <el-text tag="b"><slot name="g-price" ></slot></el-text>
      </div>

      <div class="goods-detail">
        <span class="detail-t">商品描述：</span>
        <span ><slot name="g-detail" ></slot></span>
      </div>
      <Button type="dashed">修改</Button>
    </el-card>
    </div>
</template>

<script>
export default {
    props:{
        urlList:{
            type:Array,
            deflaut:[]
        }
    },
    
}
</script>

<style>
.goods-item{
    /* width:100%, */
     margin: 1vw;
}
 .goods-name,
.goods-price,
.goods-detail{
  margin:1vw;
  display: flex;
  margin-left: 4vw;
}
</style>