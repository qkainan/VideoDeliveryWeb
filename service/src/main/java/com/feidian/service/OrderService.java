package com.feidian.service;

import com.feidian.domain.SaleOrder;

import java.util.List;

public interface OrderService {
    List<SaleOrder> findByUserId(long userId);
}
