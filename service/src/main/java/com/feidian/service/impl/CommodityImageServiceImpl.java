package com.feidian.service.impl;

import com.feidian.domain.CommodityImage;
import com.feidian.mapper.CommodityImageMapper;
import com.feidian.service.CommodityImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityImageServiceImpl implements CommodityImageService {

    @Autowired
    private CommodityImageMapper commodityImageMapper;

    @Override
    public void insertCommodityImage(long commodityId, String imageUrl, long imageStatu ) {
        commodityImageMapper.insertCommodityImage(commodityId, imageUrl, imageStatu);
    }

    @Override
    public List<CommodityImage> findByCommodityId(long CommodityId) {
        return commodityImageMapper.findByCommodityId(CommodityId);
    }
}
