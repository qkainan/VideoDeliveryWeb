package com.feidian.controller;

import com.feidian.po.*;
import com.feidian.resolver.CurrentUserId;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.JwtUtil;
import com.feidian.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;


@RestController
public class UserHomepageController {

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

    @Transactional
    @GetMapping("/getPerCommodities")
    public ResponseResult findByUserId(){
        long userId = JwtUtil.getUserId();

        List list = commodityService.findByUserId(userId);

        return new ResponseResult(200,"操作成功",list);
    }
    @Transactional
    @GetMapping("/getPerinfo")
    public ResponseResult getHomePage(){
        long userId = JwtUtil.getUserId();

        UserPO userPO = userService.findById(userId);

        List<VideoPO> videoPOList = videoService.findByUserId(userId);
        List<CommodityPO> commodityPOList = commodityService.findByUserId(userId);
        List<PurchaseOrderVO> buyerOrderVoList = getPurchaseOrderVo(userId);
        List<SaleOrderVO> sellerOrderVoList = getSaleOrderVo(userId);
        List<CartPO> cartList = cartService. findByUserId(userId);

        UserHomepageVO userHomepageVo = new UserHomepageVO(userId, userPO.getUsername(),
                userPO.getUserDescription(), userPO.getPhone(), userPO.getHeadUrl(),
                userPO.getEmailAddress(), videoPOList, commodityPOList, buyerOrderVoList,sellerOrderVoList, cartList);
        return  new ResponseResult(200,"操作成功",userHomepageVo);
    }

    @Transactional
    @GetMapping("/getPervideo")
    public ResponseResult getVideos(){
        long userId = JwtUtil.getUserId();

        List<VideoPO> videoPOList = videoService.findByUserId(userId);
        List<CommodityPO> commodityPOList = commodityService.findByUserId(userId);

        VideosVO videosVo = new VideosVO(videoPOList, commodityPOList);

        return new ResponseResult(200,"操作成功",videosVo);
    }


    public List<PurchaseOrderVO> getPurchaseOrderVo(@CurrentUserId long buyerId){
        List<OrderPO> orderList = orderService.findByBuyerId(buyerId);
        List<PurchaseOrderVO> purchaseOrderVoList = new ArrayList();

        PurchaseOrderVO purchaseOrderVo;
        for (OrderPO order : orderList) {
            UserPO buyer = userService.findById(buyerId);
            OrderCommodityPO orderCommodity = orderCommodityService.findById(order.getId());
            CommodityPO commodityPO = commodityService.findByCommodityId(orderCommodity.getCommodityId());
            UserPO seller = userService.findById(order.getSellerId());

            purchaseOrderVo = new PurchaseOrderVO(order.getId(), commodityPO.getCommodityName(),
                    commodityPO.getPrice(), commodityPO.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            purchaseOrderVoList.add(purchaseOrderVo);
        }

        return purchaseOrderVoList;
    }

    public List<SaleOrderVO> getSaleOrderVo(long sellerId) {
        List<OrderPO> orderList = orderService.findByBuyerId(sellerId);
        List<SaleOrderVO> saleOrderVoList = new ArrayList();

        SaleOrderVO saleOrderVo;
        for (OrderPO order : orderList) {

            UserPO buyer = userService.findById(sellerId);
            OrderCommodityPO orderCommodity = orderCommodityService.findById(sellerId);
            CommodityPO commodityPO = commodityService.findByCommodityId(orderCommodity.getCommodityId());
            UserPO seller = userService.findById(order.getSellerId());

            saleOrderVo = new SaleOrderVO(order.getId(), commodityPO.getCommodityName(),
                    commodityPO.getPrice(), commodityPO.getCommodityAddress(),
                    order.getOrderStatus(), order.getUpdateTime());
            saleOrderVoList.add(saleOrderVo);
        }
        return saleOrderVoList;
    }
    @Transactional
    @PutMapping("/putUserPersonalInformation")
    public ResponseResult putUserPersonalInformation(@RequestBody UserPersonalInformationVO userPersonalInformationVo) {
        userService.updateUserPersonalInformation(userPersonalInformationVo);
        return new ResponseResult(200, "发布成功");
    }
    //发送验证码

}
