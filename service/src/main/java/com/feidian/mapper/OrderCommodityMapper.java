package com.feidian.mapper;

import com.feidian.po.OrderCommodityPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderCommodityMapper {

    OrderCommodityPO findById(long id);

    void insertOrderCommodity(long orderId, long commodityId, long commodityNum);
}
