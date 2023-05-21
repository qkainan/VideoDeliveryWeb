<template>
    <div class="video-detail">
        
        <div class="v-d">
            <div class="v-d-s">
        <vue3VideoPlay 
      width="800px"
      title="钢铁侠"
      :src="options.src"
      :poster="options.poster"
      @play="onPlay"
      @pause="onPause" 
      @timeupdate="onTimeupdate" 
      @canplay="onCanplay" /></div>
        <!-- <vue3VideoPlay v-bind="options" :poster="poster /> -->
     <div class="v-detail">
            <Card style="text-align:left;min-width:300px">
                <template #title><span class="v-d-title">The standard000000000000000000000000000000000000000000000000000</span>  </template>
                <p >发布者：</p><p>qerert</p>
                <p>发布时间：</p><p>2020/02/23 10：23：34</p>
                <div class="v-d-d">
                <p>Content of cardContent of cardContent of cardContent of cardContent of cardContent of 
                    cardContent of cardContent of cardContent of card</p></div>
            </Card>
        </div>
    </div>

    <div class="v-goods">
        <div  style="font-size:large;font-weight:500;margin:1vw;">商品推荐：</div>
        <div class="v-g-wrap">
         <v-g-item v-for="(item,index) in goodsList" :key="index">
            <template v-slot:v-g-img><img
               :src="item.img"
             class="image"
              /></template>
          <template v-slot:v-g-name>{{ item.name }}</template>
         </v-g-item>
       </div>
    </div>

    </div>
     
</template>

<script>
import VGItem from './childcomponents/VGItem.vue';
export default {
    components:{
             VGItem,
    },
  props:{
    options:{
        type:Object,
        default:{
           src: "https://media.w3.org/2010/05/sintel/trailer.mp4",
           poster: '', //封面
    }
    
 },
    goodsList:{
        type:Array,
        default:[
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
            {
                img:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                name:"Yummy hamburgerYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburgeYummy hamburge"
            },
        ]
    }
  } 

}
</script>

<style>
.v-d{
    margin:5vw;
    display: flex;
    flex-direction: row;
}
.v-d-s{
    min-width:800px;
}
.v-detail{
    margin-left:1vw;
   width:30vw;
}
.v-d-title{
    word-break: break-all;
  word-wrap: break-word;
  font-size:20px;
  font-weight:700;
  
}
.v-d-d{
    font-size:16px;
    font-weight:500;
    margin:1vw 0;
}
.v-goods{
    background-color:beige ;
    text-align: left;
    margin:0 5vw;
}
.v-g-wrap{
    display: flex;
    justify-content: space-around;
  flex-wrap: wrap;
}
</style>