package com.feidian.service.impl;

import com.feidian.domain.CommodityOperLog;
import com.feidian.domain.User;
import com.feidian.mapper.CommodityOperLogMapper;

import com.feidian.service.CommodityOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityOperLogServiceImpl implements CommodityOperLogService {

    @Autowired
    private CommodityOperLogMapper commodityOperLogMapper;
    @Override
    public void saveLog(CommodityOperLog commodityOperLog) {
        commodityOperLogMapper.insertLog(commodityOperLog);
    }

    @Override
    public User findById(Integer id) {
        return commodityOperLogMapper.findById(id);
    }
}
