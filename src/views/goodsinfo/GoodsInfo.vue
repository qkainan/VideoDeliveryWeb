<template>
    <div class="goodsinfo">
    <Carousel autoplay v-model="value" loop style="width:50%" >
        <CarouselItem v-for="(item,index) in GoodsInfo.pic" :key="index">
            <div class="demo-carousel"><img :src="item"></div>
        </CarouselItem>
    </Carousel>
    <div class="g-d-info">
    <div class="g-d-name" >{{GoodsInfo.name }}</div>
    <div class="g-d-detail"><span class="detail-span">{{ GoodsInfo.detail }}</span></div>  
    <price-tag><span> {{ GoodsInfo.price }}</span></price-tag>
    <Button  style="margin:1vw 0" type="success" long>购买</Button>
    </div>
   
    <div class="goodspara" style="width:100%">
        <div class="g-p-title">
            商品参数
        </div>
        <div class="g-p-table" style="width:100%">
            <Table stripe :columns="columns" :data="data"></Table>
        </div>
    </div>

    </div>
</template>

<script>
import PriceTag from '@/components/content/pricetag/PriceTag.vue';
export default {
    components:{
            PriceTag,
    },
    data () {
            return {
                value: 0,
                columns: [
                    {
                        title: 'Name',
                        key: 'name'
                    },
                    {
                        title: 'Age',
                        key: 'age'
                    },
                    {
                        title: 'Address',
                        key: 'address'
                    }
                ],
                data: [
                    {
                        name: 'John Brown',
                        age: 18,
                        address: 'New York No. 1 Lake Park',
                        date: '2016-10-03'
                    },
                    {
                        name: 'Jim Green',
                        age: 24,
                        address: 'London No. 1 Lake Park',
                        date: '2016-10-01'
                    },
                    {
                        name: 'Joe Black',
                        age: 30,
                        address: 'Sydney No. 1 Lake Park',
                        date: '2016-10-02'
                    },
                    {
                        name: 'Jon Snow',
                        age: 26,
                        address: 'Ottawa No. 2 Lake Park',
                        date: '2016-10-04'
                    }
                ]
                 }
        } ,
    props:{  
            GoodsInfo:{
                type:Object,
                default:{
                    pic:[
                        require("@/assets/img/card01.jpg"),
                        require("@/assets/img/card02.jpg"),
                        require("@/assets/img/card03.jpg")
                    ],
                    name:"手机",
                    price:222,
                    detail:"阿萨啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊"
                }
            }
        }
}
</script>

<style>
.goodsinfo{
    min-width:1000px;
    padding:5vw 3vw;
    display: flex;
    flex-direction:row;
    flex-wrap:wrap;
}
.g-d-info{
    width:35vw;
    
}
.g-d-name{
    text-align: left;
    margin:1vw;
    font-size:26px;
    font-weight: 700;
}
.g-d-detail{
    text-align: left;
    width:100%;
    font-size: 20px;
}
.g-d-detail span{
    word-break: break-all;
  word-wrap: break-word;

}
.goodspara{
    margin:10vw;
}
</style>