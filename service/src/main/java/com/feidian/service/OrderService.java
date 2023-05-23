package com.feidian.service;

import com.feidian.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> findByUserId(long userId);
}
