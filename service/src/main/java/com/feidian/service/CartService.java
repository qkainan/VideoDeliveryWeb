package com.feidian.service;

import com.feidian.po.CartPO;
import io.lettuce.core.dynamic.annotation.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<CartPO> findByUserId(long userId);

    void updateOrderStatus(long id);

    void insertCart(@Param("userId") long userId,@Param("commodityId") long commodityId,
                    @Param("addressId") long addressId, @Param("commodityDescription") String commodityDescription,
                    @Param("price") BigDecimal price,@Param("commodityNum") BigDecimal commodityNum,
                    @Param("totalPrice") BigDecimal totalPrice,@Param("orderStatus") long orderStatus);

    CartPO findByCartId(long id);
}
