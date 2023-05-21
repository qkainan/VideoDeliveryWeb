<template>
  <div class="per-video">
    <div class="p-v-title">我发布的视频</div>
    <div class="v-wrap">

        <el-card class="box-card" style="width:550px;margin:3vw;" v-for="(item,index) in myvideo" :key="index">
          <div class="v-d">
            <div class="v-d-s">
        <vue3VideoPlay 
      width="500px"
      height=""
      title="钢铁侠"
      :src="item.src"
      :poster="item.poster"
      @play="onPlay"
      @pause="onPause" 
      @timeupdate="onTimeupdate" 
      @canplay="onCanplay" /></div>
        <!-- <vue3VideoPlay v-bind="options" :poster="poster /> -->
     <div class="v-detail">
            <Card style="text-align:left;min-width:300px">
                <template #title><span class="v-d-title">{{ item.vtitle }}</span></template>
                <p>发布时间：</p><p>{{ item.time }}</p>
                <div class="v-d-d">
                <p>{{ item.vdetail }}</p></div>
            </Card>
        </div>

        <div class="v-goods-wrap">
          <span style="text-align: left;">推荐商品：</span>
        <List >
        <ListItem v-for="(item,i) in myvideo[index].goodslist" :key="i">
            <ListItemMeta  :avatar="item.gimg" :title="item.gname" :description="item.gprice" />
        </ListItem>
        </List>
      </div>
      <Space direction="vertical" type="flex">
        <Button type="success" long>修改</Button>
        <Button type="error" long>删除</Button>
      </Space>
    </div>

      </el-card>
        
    </div>
</div>      

</template>

<script>

export default {
  props:{
    myvideo:{
      type:Array,
      default:[
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        },
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        },
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        },
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        },
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        },
        {
          src:"https://media.w3.org/2010/05/sintel/trailer.mp4",
          poster:'',
          vtitle:"sasfs",
          time:"2324",
          vdetail:"adsvnzxucjfnakdn,vnzkfdsdfgsdfg",
          goodslist:[
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            },
            {
              gimg:"https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar",
              gname:"wueqirwrut",
              gprice:"1222222222222222222222222222222222222222222222222"
            }
          ]
        }
      ]
    },
   },
   
}
</script>

<style>
.per-video{
  min-width:800px;
}
.v-d{
  width:500px;
}
.p-v-title{
  margin:1vw 2vw;
  font-size: large;
  text-align: left;
}
.v-wrap{
  display: flex;
  flex-wrap: wrap;
}
.v-d-s{
  background-color: aliceblue;
}
.v-goods-wrap{
  padding:1vw;
  text-align: left;
}
</style>