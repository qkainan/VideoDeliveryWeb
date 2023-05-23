package com.feidian.service.impl;

import com.feidian.domain.Cart;
import com.feidian.mapper.CartMapper;
import com.feidian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> findByUserId(long userId) {
        return cartMapper.findByUserId(userId);
    }
}
