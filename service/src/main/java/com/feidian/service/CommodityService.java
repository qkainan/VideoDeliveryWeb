package com.feidian.service;

import com.feidian.domain.Commodity;
import io.lettuce.core.dynamic.annotation.Param;


import java.math.BigDecimal;
import java.util.List;

public interface CommodityService {


    void deleteCommodity(long commodityId);

    void updateCommodityDescription(String description);

    List<Commodity> findByUserId(long id);

    Commodity findByCommodityId(@Param("commodityId") long commodityId);

    void insertCommodity( @Param("userId") long userId, @Param("commodityName")String commodityName,
                          @Param("commodityType") String commodityType,@Param("price") BigDecimal price, @Param("commodityDescription")String commodityDescription,
                          @Param("")String commodityAddress,@Param("coverUrl") String coverUrl);

}
