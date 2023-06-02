package com.feidian.service.impl;

import com.feidian.mapper.OrderCommodityMapper;
import com.feidian.po.OrderCommodityPO;
import com.feidian.service.OrderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCommodityImpl implements OrderCommodityService {

    @Autowired
    private OrderCommodityMapper orderCommodityMapper;

    @Override
    public OrderCommodityPO findById(long id) {
        return orderCommodityMapper.findById(id);
    }

    @Override
    public void insertOrderCommodity(long orderId, long commodityId, long commodityNum) {
        orderCommodityMapper.insertOrderCommodity(orderId, commodityId, commodityNum);
    }
}
