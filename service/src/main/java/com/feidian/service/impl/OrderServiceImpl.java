package com.feidian.service.impl;

import com.feidian.bo.OrderBO;
import com.feidian.mapper.OrderMapper;
import com.feidian.po.OrderPO;
import com.feidian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderPO> findByBuyerId(long buyerId) {
        return orderMapper.findByBuyerId(buyerId);
    }

    @Override
    public List<OrderPO> findBySellerId(long sellerId) {
        return orderMapper.findBySellerId(sellerId);
    }

    @Override
    public void insertOrder(OrderBO orderBO) {
        orderMapper.insertOrder(orderBO);
    }

    @Override
    public void updateStatus(long orderId) {
        orderMapper.updateStatus(orderId);
    }

}
