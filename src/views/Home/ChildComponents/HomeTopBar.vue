<template>
  <div class="Home-top-bar">
    <tab-bar>
      <template v-slot:left>
        <div class="left-info">
          <div @click="this.$router.push('/Login')">请登录</div>
        </div>
      </template>
      <template v-slot:right>
        <!-- <div class="nav-right">我的订单</div> -->
        <div class="nav-right" @click="this.$router.push('/perinfo')">
          我的信息
        </div>
        <div class="nav-right" @click="this.$router.push('/pergoods')">
          我的商品
        </div>
        <div class="nav-right" @click="this.$router.push('/pervideo')">
          我的视频
        </div>
        <div class="nav-right" @click="this.$router.push('/sendvideo')">
          发送视频
        </div>
      </template>
    </tab-bar>
  </div>
</template>

<script>
import TabBar from "@/components/common/tabbar/TabBar.vue";
import TabBarItem from "@/components/common/tabbar/TabBarItem.vue";
export default {
  data() {
    return {
      array1: ["个人信息", "我的订单", "我的视频", "", "ttt"],
    };
  },
  components: {
    TabBar,
    TabBarItem,
  },
  methods: {},
};
</script>

<style>
.Home-top-bar {
  font-size: 14px;
}
.right-info {
  flex: 1;
}
.nav-right {
  margin-right: 2vw;
}
</style>
