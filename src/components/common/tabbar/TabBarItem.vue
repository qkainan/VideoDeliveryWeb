<template>
  <div class="tab-bar-item">
   <a>
    <span class="tab-bar-item-text"><slot name="text"></slot></span>
    <span  class="tab-bar-item-icon"><slot name="icon"></slot></span>
    </a>
    
  </div>
</template>

<script>
export default {

}
</script>

<style>
  .tab-bar-item{
    text-align: center;
    height:27px;
    line-height:27px;
  }
  .tab-bar-item-text{
    font-size:14px;

  }
  .tab-bar-item-icon{
    font-size:16px;
    padding-left:10px;
    display: inline-block;
  } 
</style>