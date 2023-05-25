package com.feidian.service.impl;

import com.feidian.domain.Order;
import com.feidian.mapper.OrderMapper;
import com.feidian.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findByBuyerId(long buyerId) {
        return orderMapper.findByBuyerId(buyerId);
    }

    @Override
    public List<Order> findBySellerId(long sellerId) {
        return orderMapper.findBySellerId(sellerId);
    }
}
