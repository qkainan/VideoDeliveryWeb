package com.feidian.controller;


import com.feidian.po.CommodityPO;
import com.feidian.po.OrderCommodityPO;
import com.feidian.po.OrderPO;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.OrderCommodityService;
import com.feidian.service.OrderService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.PurchaseOrderVO;
import com.feidian.vo.SaleOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public ResponseResult getPurchaseOrder(){
        List<PurchaseOrderVO> purchaseOrderVoList = new ArrayList<>();

        for (OrderPO o : orderService.findByBuyerId(JwtUtil.getUserId())) {

            OrderCommodityPO orderCommodity = orderCommodityService.findById(o.getId());
            CommodityPO commodityPO = commodityService.findByCommodityId(orderCommodity.getCommodityId());

            PurchaseOrderVO purchaseOrderVo = new PurchaseOrderVO(o.getId(), commodityPO.getCommodityName(), commodityPO.getPrice(),
                    commodityPO.getCommodityAddress(), o.getOrderStatus(), o.getUpdateTime());

            purchaseOrderVoList.add(purchaseOrderVo);
        }

        return new ResponseResult(200,"操作成功",purchaseOrderVoList);
    }

    @GetMapping("/getSaleOrder")
    @Transactional
    public ResponseResult getSaleOrder(){
        List<SaleOrderVO> saleOrderVoList = new ArrayList<>();

        for (OrderPO o : orderService.findBySellerId(JwtUtil.getUserId())) {

            OrderCommodityPO orderCommodity = orderCommodityService.findById(o.getId());
            CommodityPO commodityPO = commodityService.findByCommodityId(orderCommodity.getCommodityId());

            SaleOrderVO saleOrderVo = new SaleOrderVO(o.getId(), commodityPO.getCommodityName(), commodityPO.getPrice(),
                    commodityPO.getCommodityAddress(), o.getOrderStatus(), o.getUpdateTime());

            saleOrderVoList.add(saleOrderVo);
        }
        return new ResponseResult(200,"操作成功",saleOrderVoList);
    }

}
