package com.feidian.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommodityImageMapper {
    void insertCommodityImage(long commodityId, String imageUrl, long imageStatu);
}