<template>
  <div class="pergoods">
    <div class="title1"><span>新增商品</span></div>
    <add-goods></add-goods>
    <el-divider border-style="dashed" />
    <div class="title2"><span>我的货架</span></div>
    <div class="my-goods">
      <goods-item v-for="(item, index) in goodsinfo" :key="index">
        <template v-slot:g-img>
          <Space wrap>
            <template v-for="(url, i) in goodsinfo[index].imglist" :key="i">
              <Image
                :src="url"
                fit="contain"
                width="120px"
                height="80px"
                preview
                :preview-list="goodsinfo[index].imglist"
                :initial-index="index"
              />
            </template>
          </Space>
        </template>
        <template v-slot:g-name>{{ item.goodsname }}</template>
        <template v-slot:g-price>{{ item.goodsprice }}</template>
        <template v-slot:g-detail>{{ item.goodsdetail }}</template>
      </goods-item>
    </div>
  </div>
</template>

<script>
import AddGoods from "./childcomponents/AddGoods.vue";
import GoodsItem from "./childcomponents/GoodsItem.vue";

export default {
  components: { AddGoods, GoodsItem },
  props: {
    goodsinfo: {
      type: Array,
      default: [
        {
          index: 0,
          id: 1,
          imglist: [
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-2.jpg",
            "https://file.iviewui.com/images/image-demo-3.jpg",
            "https://file.iviewui.com/images/image-demo-4.jpg",
            "https://file.iviewui.com/images/image-demo-5.jpg",
            "https://file.iviewui.com/images/image-demo-6.jpg",
          ],
          goodsname: "hhh",
          goodsprice: 222,
          goodsdetail:
            "sadfhaskjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
        },
        {
          index: 1,
          id: 1,
          imglist: [
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-1.jpg",
            "https://file.iviewui.com/images/image-demo-2.jpg",
            "https://file.iviewui.com/images/image-demo-3.jpg",
            "https://file.iviewui.com/images/image-demo-4.jpg",
            "https://file.iviewui.com/images/image-demo-5.jpg",
            "https://file.iviewui.com/images/image-demo-6.jpg",
          ],
          goodsname: "hhh",
          goodsprice: 222,
          goodsdetail:
            "sadfhaskjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj",
        },
      ],
    },
  },
};
</script>

<style>
.pergoods {
  background-color: cornsilk;
  padding: 3vw;
  height: 100%;
}
.title1,
.title2 {
  font-size: large;
  color: rgb(133, 128, 128);
  text-align: left;
}

.my-goods {
  display: flex;
  flex-direction: column-reverse;
  justify-content: space-around;
}
</style>
