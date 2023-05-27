package com.feidian.service;

import com.feidian.domain.CommodityImage;

import java.util.List;

public interface CommodityImageService {

    void insertCommodityImage(long commodityId, String imageUrl, long imageStatu);

    List<CommodityImage> findByCommodityId(long CommodityId);
}
