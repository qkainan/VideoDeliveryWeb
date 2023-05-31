package com.feidian.service.impl;

import com.feidian.po.CommodityOperLogPO;
import com.feidian.po.UserPO;
import com.feidian.mapper.CommodityOperLogMapper;

import com.feidian.service.CommodityOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityOperLogServiceImpl implements CommodityOperLogService {

    @Autowired
    private CommodityOperLogMapper commodityOperLogMapper;
    @Override
    public void saveLog(CommodityOperLogPO commodityOperLogPO) {
        commodityOperLogMapper.insertLog(commodityOperLogPO);
    }

    @Override
    public UserPO findById(long id) {
        return commodityOperLogMapper.findById(id);
    }
}
