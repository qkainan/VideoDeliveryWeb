package com.feidian.mapper;

import com.feidian.po.OrderPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    List<OrderPO> findByBuyerId(long buyerId);

    List<OrderPO> findBySellerId(long sellerId);

    void insertOrder(long id, long userId, long userId1, String addressName, String commodityAddress, long orderStatus);

    void updateStatus(long orderId);
}
