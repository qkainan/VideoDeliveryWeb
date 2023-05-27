package com.feidian.service.impl;

import com.feidian.domain.Cart;
import com.feidian.mapper.CartMapper;
import com.feidian.service.CartService;
import com.feidian.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> findByUserId(long userId) {
        return cartMapper.findByUserId(userId);
    }

    @Override
    public void updateOrderStatus(long id, long orderStatus) {
        cartMapper.updateOrderStatus(id, orderStatus);
    }

    @Override
    public void insertCart(long id, long userId, long commodityId, long addressId,
                           String commodityDescription, BigDecimal price,
                           BigDecimal commodityNum, BigDecimal totalPrice, long orderStatus) {
        cartMapper.insertCart(id, userId, commodityId, addressId,
                commodityDescription, price, commodityNum, totalPrice, orderStatus);
    }

}
