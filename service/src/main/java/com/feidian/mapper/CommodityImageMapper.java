package com.feidian.mapper;

import com.feidian.domain.CommodityImage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommodityImageMapper {
    void insertCommodityImage(long commodityId, String imageUrl, long imageStatu);

    List<CommodityImage> findByCommodityId(long commodityId);
}
