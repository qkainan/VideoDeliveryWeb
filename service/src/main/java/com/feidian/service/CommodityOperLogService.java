package com.feidian.service;

import com.feidian.domain.CommodityOperLog;
import com.feidian.domain.User;

public interface CommodityOperLogService {

    void saveLog(CommodityOperLog commodityOperLog);

    User findById(Integer id);

}
