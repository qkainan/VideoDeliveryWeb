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


//    void insertCommodity(@Param("userId") long userId, @Param("commodityName")String commodityName,
//                         @Param("commodityType")String commodityType,@Param("price") BigDecimal price,
//                         @Param("commodityDescription")String commodityDescription,
//                         @Param("commodityAddress")String commodityAddress,@Param("coverUrl") String coverUrl);
    void insertCommodity(Commodity commodity);
    void insertInCommodity(long commodityId, String coverUrl);
}
