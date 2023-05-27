package com.feidian.service;

import com.feidian.domain.Order;

import java.util.List;

public interface OrderService {

    //买家订单
    List<Order> findByBuyerId(long userId);

    //卖家订单
    List<Order> findBySellerId(long userId);

    void insertOrder(long id, long userId, long userId1, String addressName, String commodityAddress, long orderStatus);

    void updateStatus(long orderId);
}
