package com.feidian.mapper;

import com.feidian.domain.Commodity;

import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Mapper
public interface CommodityMapper {


    void deleteCommodity(long commodityId);

    void updateCommodityDescription(String description);

    List<Commodity> findByUserId(long id);

    Commodity findByCommodityId(@Param("commodityId") long commodityId);


    void insertCommodity(long id, long userId, String commodityName,
                         String commodityType, BigDecimal price,
                         String commodityDescription, String commodityAddress, String coverUrl);

    void insertInCommodity(long commodityId, String coverUrl);
}
