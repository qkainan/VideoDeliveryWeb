package com.feidian.service;

import com.feidian.dto.CommodityDTO;
import com.feidian.po.CommodityPO;
import io.lettuce.core.dynamic.annotation.Param;


import java.util.List;

public interface CommodityService {


    void deleteCommodity(long commodityId);

    void updateCommodityDescription(String description);

    List<CommodityPO> findByUserId(long id);

    CommodityPO findByCommodityId(@Param("commodityId") long commodityId);

//    void insertCommodity( @Param("userId") long userId, @Param("commodityName")String commodityName,
//                          @Param("commodityType") String commodityType,@Param("price") BigDecimal price, @Param("commodityDescription")String commodityDescription,
//                          @Param("")String commodityAddress,@Param("coverUrl") String coverUrl);
    void insertCommodity( CommodityPO commodityPO);

    void updateCommodity(CommodityDTO commodityDTO);
}
