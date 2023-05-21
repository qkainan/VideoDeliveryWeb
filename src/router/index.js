import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    redirect:"/home"
  },
  {
     path:'/home',
     component:()=>import('@/views/Home/Home.vue'),
     children:[]
     
  },
   {
        path:'/videodetail',
        component:()=>import('@/views/video/VideoDetail.vue')
     },
    
  {
       name:'Login',
        path:'/Login',
        component:()=>import('@/views/Login/LoginIn.vue'),
  },
  {
        path:'/perinfo',
        component:()=>import('@/views/Perinfo/PerInfo.vue'),
  },
  {
        path:'/pergoods',
        component:()=>import('@/views/Pergoods/PerGoods.vue'),
  },
  {
        path:'/pervideo',
        component:()=>import('@/views/Pervideo/PerVideo.vue'),
  }, 
  {
    path:'/sendvideo',
    component:()=>import('@/views/sendvideo/SendVideo.vue'),
},

  {
    
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  } ,
    {
          path:'/goodsinfo',
          component:()=>import('@/views/goodsinfo/GoodsInfo.vue'),
        },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
