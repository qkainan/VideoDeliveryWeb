package com.feidian.mapper;

import com.feidian.bo.OrderBO;
import com.feidian.po.OrderPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    List<OrderPO> findByBuyerId(long buyerId);

    List<OrderPO> findBySellerId(long sellerId);

    void insertOrder(OrderBO orderBO);

    void updateStatus(long orderId);

}
