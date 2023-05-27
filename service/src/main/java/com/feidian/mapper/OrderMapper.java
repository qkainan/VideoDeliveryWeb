package com.feidian.mapper;

import com.feidian.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    List<Order> findByBuyerId(long buyerId);

    List<Order> findBySellerId(long sellerId);

    void insertOrder(long id, long userId, long userId1, String addressName, String commodityAddress, long orderStatus);
}
