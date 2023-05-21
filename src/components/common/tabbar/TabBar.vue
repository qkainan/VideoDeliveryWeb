<template>
  <div class="tab-bar">
    <div class="tab-bar-info">
      <div class="left"><slot name="left"></slot></div>
      <div class="zw"></div>
      <div class="right"><slot name="right"></slot></div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.tab-bar {
  position: absolute;
  top: 0;
  width: 100%;
  height: 27px;
  background-color: #f5f5f5;
  box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.1);
}
.tab-bar-info {
  height: 100%;
  width: 1000px;
  margin: 0 auto;
  margin-top: 2px;
  display: flex;
}
.zw {
  flex: 2;
}
.left {
  flex: 2;
  display: flex;
}
.right {
  flex: 4;
  display: flex;
}
</style>
