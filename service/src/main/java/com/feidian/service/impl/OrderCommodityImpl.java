package com.feidian.service.impl;

import com.feidian.po.OrderCommodity;
import com.feidian.mapper.OrderCommodityMapper;
import com.feidian.service.OrderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCommodityImpl implements OrderCommodityService {

    @Autowired
    private OrderCommodityMapper orderCommodityMapper;

    @Override
    public OrderCommodity findById(long id) {
        return orderCommodityMapper.findById(id);
    }
}
