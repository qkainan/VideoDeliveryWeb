package com.feidian.mapper;

import com.feidian.po.CommodityPO;

import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityMapper {


    void deleteCommodity(long commodityId);

    void updateCommodityDescription(String description);

    List<CommodityPO> findByUserId(long id);

    CommodityPO findByCommodityId(@Param("commodityId") long commodityId);


//    void insertCommodity(@Param("userId") long userId, @Param("commodityName")String commodityName,
//                         @Param("commodityType")String commodityType,@Param("price") BigDecimal price,
//                         @Param("commodityDescription")String commodityDescription,
//                         @Param("commodityAddress")String commodityAddress,@Param("coverUrl") String coverUrl);
    void insertCommodity(CommodityPO commodityPO);
    void insertInCommodity(long commodityId, String coverUrl);

    void updateCommodity(CommodityPO commodityPO);
}
