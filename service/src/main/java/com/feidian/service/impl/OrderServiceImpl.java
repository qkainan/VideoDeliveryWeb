package com.feidian.service.impl;

import com.feidian.domain.SaleOrder;
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
    public List<SaleOrder> findByUserId(long userId) {
        return orderMapper.findByUserId(userId);
    }
}
