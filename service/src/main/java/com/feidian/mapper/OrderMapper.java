package com.feidian.mapper;

import com.feidian.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {
    List<Order> findByUserId(long userId);
}
