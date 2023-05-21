<template>
  <div class="price-tag">
    <div class="price">
      <div class="p-icon">￥</div>
      <div class="p-number">
        <slot >222</slot>
      </div>
    </div>
   
    <div class="price-tag-right"></div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
   .price-tag{
    color:#fff;
    background-image: url('@/assets/img/price01.png');
    background-size: contain;
    width:35vw;
    height:8vw;
    display: flex;
   }
   .price{
    width:60%;
    display: flex;
   }
   .p-icon{
    font-size:16px;
    font-weight:600;
    margin-left:5vw;
    line-height:8vw;
   }
   .p-number{
    margin-left:1vw;
    font-size:30px;
    font-weight: 1000;
    line-height:8vw;
   }
   .price-tag-right{
    background-image: url('@/assets/img/price02.png');
    background-position: 4vw;
    height:8vw;
    background-size:contain;
    background-repeat: no-repeat;
    flex: 1;
   }
</style>