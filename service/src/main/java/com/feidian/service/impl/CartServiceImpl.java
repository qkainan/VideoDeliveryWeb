package com.feidian.service.impl;

import com.feidian.po.CartPO;
import com.feidian.mapper.CartMapper;
import com.feidian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<CartPO> findByUserId(long userId) {
        return cartMapper.findByUserId(userId);
    }

    @Override
    public void updateOrderStatus(long id) {
        cartMapper.updateOrderStatus(id, 1);
    }

    @Override
    public void insertCart(long userId, long commodityId, long addressId,
                           String commodityDescription, BigDecimal price,
                           BigDecimal commodityNum, BigDecimal totalPrice, long orderStatus) {
        cartMapper.insertCart( userId, commodityId, addressId,
                commodityDescription, price, commodityNum, totalPrice, orderStatus);
    }

    @Override
    public CartPO findByCartId(long id) {
        return cartMapper.findByCartId(id);
    }

    @Override
    public void deleteCart(long cartId) {
        cartMapper.deleteCart(cartId);
    }


}
