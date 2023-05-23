package com.feidian.service;

import com.feidian.domain.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findByUserId(long userId);
}
