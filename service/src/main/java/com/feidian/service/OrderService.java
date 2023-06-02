package com.feidian.service;

import com.feidian.bo.OrderBO;
import com.feidian.po.OrderPO;

import java.util.List;

public interface OrderService {

    //买家订单
    List<OrderPO> findByBuyerId(long userId);

    //卖家订单
    List<OrderPO> findBySellerId(long userId);

    void insertOrder(OrderBO orderBO);

    void updateStatus(long orderId);

}
