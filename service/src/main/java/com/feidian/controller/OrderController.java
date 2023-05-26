package com.feidian.controller;


import com.feidian.domain.Commodity;
import com.feidian.domain.Order;
import com.feidian.domain.OrderCommodity;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.OrderCommodityService;
import com.feidian.service.OrderService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.PurchaseOrderVo;
import com.feidian.vo.SaleOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderCommodityService orderCommodityService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/getPurchaseOrder")
    public ResponseResult getPurchaseOrder(){
        List<PurchaseOrderVo> purchaseOrderVoList = new ArrayList<>();

        for (Order o : orderService.findByBuyerId(JwtUtil.getUserId())) {

            OrderCommodity orderCommodity = orderCommodityService.findById(o.getId());
            Commodity commodity = commodityService.findByCommodityId(orderCommodity.getCommodityId());

            PurchaseOrderVo purchaseOrderVo = new PurchaseOrderVo(o.getId(), commodity.getCommodityName(), commodity.getPrice(),
                    commodity.getCommodityAddress(), o.getOrderStatus(), o.getUpdateTime());

            purchaseOrderVoList.add(purchaseOrderVo);
        }

        return new ResponseResult(200,"操作成功",purchaseOrderVoList);
    }

    @GetMapping("/getSaleOrder")
    public ResponseResult getSaleOrder(){
        List<SaleOrderVo> saleOrderVoList = new ArrayList<>();

        for (Order o : orderService.findBySellerId(JwtUtil.getUserId())) {

            OrderCommodity orderCommodity = orderCommodityService.findById(o.getId());
            Commodity commodity = commodityService.findByCommodityId(orderCommodity.getCommodityId());

            SaleOrderVo saleOrderVo = new SaleOrderVo(o.getId(), commodity.getCommodityName(), commodity.getPrice(),
                    commodity.getCommodityAddress(), o.getOrderStatus(), o.getUpdateTime());

            saleOrderVoList.add(saleOrderVo);
        }
        return new ResponseResult(200,"操作成功",saleOrderVoList);
    }

}
