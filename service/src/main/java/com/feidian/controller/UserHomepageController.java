package com.feidian.controller;

import com.feidian.domain.*;
import com.feidian.resolver.CurrentUserId;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.EmailUtil;
import com.feidian.util.JwtUtil;
import com.feidian.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
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

    @Autowired
    private OrderCommodityService orderCommodityService;


    @GetMapping("/getPerCommodities")
    public ResponseResult findByUserId(){
        long userId = JwtUtil.getUserId();

        List list = commodityService.findByUserId(userId);

        return new ResponseResult(200,"操作成功",list);
    }

    @GetMapping("/getPerinfo")
    public ResponseResult getHomePage(){
        long userId = JwtUtil.getUserId();

        User user = userService.findById(userId);

        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);
        List<PurchaseOrderVo> buyerOrderVoList = getPurchaseOrderVo(userId);
        List<SaleOrderVo> sellerOrderVoList = getSaleOrderVo(userId);
        List<Cart> cartList = cartService. findByUserId(userId);

        UserHomepageVo userHomepageVo = new UserHomepageVo(userId, user.getUsername(),
                user.getUserDescription(), user.getPhone(), user.getHeadUrl(),
                user.getEmailAddress(), videoList, commodityList, buyerOrderVoList,sellerOrderVoList, cartList);
        return  new ResponseResult(200,"操作成功",userHomepageVo);
    }


    @GetMapping("/getPervideo")
    public ResponseResult getVideos(){
        long userId = JwtUtil.getUserId();

        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);

        VideosVo videosVo = new VideosVo(videoList, commodityList);

        return new ResponseResult(200,"操作成功",videosVo);
    }


    public List<PurchaseOrderVo> getPurchaseOrderVo(@CurrentUserId long buyerId){
        List<Order> orderList = orderService.findByBuyerId(buyerId);
        List<PurchaseOrderVo> purchaseOrderVoList = new ArrayList();

        PurchaseOrderVo purchaseOrderVo;
        for (Order order : orderList) {
            User buyer = userService.findById(buyerId);
            OrderCommodity orderCommodity = orderCommodityService.findById(order.getId());
            Commodity commodity = commodityService.findByCommodityId(orderCommodity.getCommodityId());
            User seller = userService.findById(order.getSellerId());

            purchaseOrderVo = new PurchaseOrderVo(order.getId(), commodity.getCommodityName(),
                    commodity.getPrice(), commodity.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            purchaseOrderVoList.add(purchaseOrderVo);
        }

        return purchaseOrderVoList;
    }

    public List<SaleOrderVo> getSaleOrderVo(long sellerId) {
        List<Order> orderList = orderService.findByBuyerId(sellerId);
        List<SaleOrderVo> saleOrderVoList = new ArrayList();

        SaleOrderVo saleOrderVo;
        for (Order order : orderList) {

            User buyer = userService.findById(sellerId);
            OrderCommodity orderCommodity = orderCommodityService.findById(sellerId);
            Commodity commodity = commodityService.findByCommodityId(orderCommodity.getCommodityId());
            User seller = userService.findById(order.getSellerId());

            saleOrderVo = new SaleOrderVo(order.getId(), commodity.getCommodityName(),
                    commodity.getPrice(), commodity.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            saleOrderVoList.add(saleOrderVo);
        }
        return saleOrderVoList;
    }

    @PutMapping("/putUserPersonalInformation")
    public ResponseResult putUserPersonalInformation(@RequestBody UserPersonalInformationVo userPersonalInformationVo) {
        userService.updateUserPersonalInformation(userPersonalInformationVo);
        return new ResponseResult(200, "发布成功");
    }
    //发送验证码

}
