package com.feidian.mapper;

import com.feidian.domain.Cart;
import com.feidian.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface CartMapper {
    List<Cart> findByUserId(long userId);

    void updateOrderStatus(long id, long orderStatus);

    void insertCart(CartVo cartVo);

    void insertCart(long id, long userId, long commodityId, long addressId,
                    String commodityDescription, BigDecimal price, BigDecimal commodityNum,
                    BigDecimal totalPrice, long orderStatus);
}
