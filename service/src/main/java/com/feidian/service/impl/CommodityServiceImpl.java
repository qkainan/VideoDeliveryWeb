package com.feidian.service.impl;

import com.feidian.domain.Commodity;
import com.feidian.domain.Video;
import com.feidian.mapper.CommodityMapper;
import com.feidian.service.CommodityService;
import com.feidian.vo.CommodityVo;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Override
    public void deleteCommodity(long commodityId) {
        commodityMapper.deleteCommodity(commodityId);
    }

    public void updateCommodityDescription(String description){
        commodityMapper.updateCommodityDescription(description);
    };

    @Override
    public List<Commodity> findByUserId(long id) {
        return commodityMapper.findByUserId(id);
    }

    @Override
    public Commodity findByCommodityId(@Param("commodityId") long commodityId) {
        return commodityMapper.findByCommodityId(commodityId);
    }

    @Override
    public void insertCommodity( @Param("userId") long userId,@Param("commodityName") String commodityName,
                                 @Param("commodityType")String commodityType,@Param("price") BigDecimal price,
                                 @Param("commodityDescription") String commodityDescription,
                                 @Param("commodityAddress")String commodityAddress, @Param("coverUrl")String coverUrl) {
        commodityMapper.insertCommodity( userId, commodityName, commodityType, price,
                commodityDescription, commodityAddress, coverUrl);
    }



}
