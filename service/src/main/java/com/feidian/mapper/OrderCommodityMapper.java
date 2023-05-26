package com.feidian.mapper;

import com.feidian.domain.OrderCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderCommodityMapper {

    OrderCommodity findById(long id);
}
