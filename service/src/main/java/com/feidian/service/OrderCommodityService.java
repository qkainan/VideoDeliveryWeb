package com.feidian.service;

import com.feidian.po.OrderCommodityPO;

public interface OrderCommodityService {

    OrderCommodityPO findById(long id);

    void insertOrderCommodity(long orderId, long commodityId, long commodityNum);
}
