package com.feidian.service;

import com.feidian.po.OrderPO;

import java.util.List;

public interface OrderService {

    //买家订单
    List<OrderPO> findByBuyerId(long userId);

    //卖家订单
    List<OrderPO> findBySellerId(long userId);

    void insertOrder(long id, long userId, long userId1, String addressName, String commodityAddress, long orderStatus);

    void updateStatus(long orderId);
}
