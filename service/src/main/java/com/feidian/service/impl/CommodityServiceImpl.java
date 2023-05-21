package com.feidian.service.impl;

import com.feidian.mapper.CommodityMapper;
import com.feidian.service.CommodityService;
import com.feidian.vo.CommodityVo;
import org.springframework.stereotype.Service;

@Service
public class CommodityServiceImpl implements CommodityService {

    private CommodityMapper commodityMapper;

    @Override
    public void releaseCommodity(CommodityVo commodityVo) {
        commodityMapper.insertCommodity(commodityVo);
    }
}
