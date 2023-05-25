package com.feidian.controller;

import com.feidian.domain.*;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.JwtUtil;
import com.feidian.vo.BuyerOrderVo;
import com.feidian.vo.SellerOrderVo;
import com.feidian.vo.UserHomepageVo;
import com.feidian.vo.VideosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class UserHomepageController {

    //Todo 上传视频（视频名称、视频封面、编写视频简介、获取视频发布时间） 视频资源路径
    // 发布商品（商品名称、价格、商品简介、商品封面、获取商品发布时间）
    // 编写个人签名

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;


    public ResponseResult writePersonalDescription(@RequestBody UserHomepageVo userHomepageVo){
        userService.updateUserDescription(userHomepageVo.getUserDescription());
        return new ResponseResult(200,"发布成功");
    }

    @GetMapping("/getPerinfo")
    public ResponseResult getHomePage(){
        long userId = JwtUtil.getUserId();

        User user = userService.findById(userId);

        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);
        List<BuyerOrderVo> buyerOrderVoList = getBuyerOrderVo(userId);
        List<SellerOrderVo> sellerOrderVoList = getSellerOrderVo(userId);
        List<Cart> cartList = cartService. findByUserId(userId);

        UserHomepageVo userHomepageVo = new UserHomepageVo(userId, user.getUsername(),
                user.getUserDescription(), user.getPhone(), user.getHeadUrl(),
                user.getEmailAddress(), videoList, commodityList, buyerOrderVoList,sellerOrderVoList, cartList);
        return  new ResponseResult(200,"操作成功",userHomepageVo);
    }


    //Todo video commodity 对应表
    @GetMapping("/getPervideo")
    public ResponseResult getVideos(){
        long userId = JwtUtil.getUserId();

        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);

        VideosVo videosVo = new VideosVo(videoList, commodityList);

        return new ResponseResult(200,"操作成功",videosVo);
    }

    //创建订单Vo
    public List<BuyerOrderVo> getBuyerOrderVo(long buyerId){
        List<Order> orderList = orderService.findByBuyerId(buyerId);
        List<BuyerOrderVo> buyerOrderVoList = new ArrayList();

        BuyerOrderVo buyerOrderVo;
        for (Order order : orderList) {
            User buyer = userService.findById(buyerId);
            Commodity commodity = commodityService.findByCommodityId(order.getCommodityId());
            User seller = userService.findById(order.getSellerId());

            buyerOrderVo = new BuyerOrderVo(order.getId(), commodity.getCommodityName(),
                    commodity.getPrice(), commodity.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            buyerOrderVoList.add(buyerOrderVo);
        }

        return buyerOrderVoList;
    }
    public List<SellerOrderVo> getSellerOrderVo(long sellerId){
        List<Order> orderList = orderService.findByBuyerId(sellerId);
        List<SellerOrderVo> sellerOrderVoList = new ArrayList();

        SellerOrderVo sellerOrderVo;
        for (Order order : orderList) {
            User buyer = userService.findById(sellerId);
            Commodity commodity = commodityService.findByCommodityId(order.getCommodityId());
            User seller = userService.findById(order.getSellerId());

            sellerOrderVo = new SellerOrderVo(order.getId(), commodity.getCommodityName(),
                    commodity.getPrice(), commodity.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            sellerOrderVoList.add(sellerOrderVo);
        }
        return sellerOrderVoList;
    }

}
