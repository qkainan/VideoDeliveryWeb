<template>
  <home-top-bar></home-top-bar>
   <div class="video-wrap">
    <div class="video-item" v-for='item in homevideo' :key="item.id">
    <Card style="width:20vw" @click="this.$router.push('/videodetail')">
        <div style="text-align:center">
            <img :src="item.img" style="width:100%;height:100%">
            <h3>{{ item.title }}</h3>
            <el-text class="w-15vw" truncated>{{ item.detail }}</el-text>
            
        </div>
    </Card>
  </div>
   </div>

</template>

<script>
import VideoPage from '@/components/content/video/VideoPage.vue';
import VideoItem from '@/components/content/video/VideoItem.vue';

import HomeTopBar from './ChildComponents/HomeTopBar.vue';

export default {
   
        props: {
       homevideo:{
        type:Array,
        default:[
          { 
            id:1,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'00000000000000000000000000000000000000000000000000000000000'
          },
          { 
            id:2,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'00000001111111000'
          },
          { 
            id:2,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'0000000000'
          },
          { 
            id:2,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'000000000999999999999999990'
          },
          { 
            id:2,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'0000000000'
          },
          { 
            id:3,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'0000000000'
          },
          { 
            id:4,
            img:require("@/assets/logo.png"),
            title:"999999999",
            detail:'0000000000'
          }
        ]
       },
      
    
   },
   components:{
    HomeTopBar,
      VideoItem,
      VideoPage
   }
  }
</script>

<style>
.video-wrap{
  padding:3vw 8vw;
  background-color: antiquewhite;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.video-item{
  margin:1vw 0;
}
</style>