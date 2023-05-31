package com.feidian.mapper;

import com.feidian.po.CartPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface CartMapper {
    List<CartPO> findByUserId(long userId);

    void updateOrderStatus(long id, long orderStatus);


    void insertCart(long userId, long commodityId, long addressId,
                    String commodityDescription, BigDecimal price,
                    BigDecimal commodityNum, BigDecimal totalPrice, long orderStatus);
}
