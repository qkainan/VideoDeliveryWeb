package com.feidian.service.impl;

import com.feidian.domain.Commodity;
import com.feidian.mapper.CommodityMapper;
import com.feidian.service.CommodityService;
import com.feidian.vo.CommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;
    public void updateCommodityDescription(String description){
        commodityMapper.updateCommodityDescription(description);
    };
    @Override
    public void releaseCommodity(CommodityVo commodityVo) {
        commodityMapper.insertCommodity(commodityVo);
    }

    @Override
    public List<Commodity> findByUserId(long id) {
        return commodityMapper.findByUserId(id);
    }

    @Override
    public Commodity findByCommodityId(long id) {
        return commodityMapper.findByCommodityId(id);
    }
}