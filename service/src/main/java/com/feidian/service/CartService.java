package com.feidian.service;

import com.feidian.domain.Cart;
import com.feidian.vo.CartVo;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<Cart> findByUserId(long userId);

    void updateOrderStatus(long id, long orderStatus);

    void insertCart(long id, long userId, long commodityId, long addressId, String commodityDescription, BigDecimal price, BigDecimal commodityNum, BigDecimal totalPrice, long orderStatus);
}
