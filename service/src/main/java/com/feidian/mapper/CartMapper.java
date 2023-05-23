package com.feidian.mapper;

import com.feidian.domain.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CartMapper {
    List<Cart> findByUserId(long userId);
}
