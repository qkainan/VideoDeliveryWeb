package com.feidian.service;

import com.feidian.po.CommodityOperLogPO;
import com.feidian.po.UserPO;

public interface CommodityOperLogService {

    void saveLog(CommodityOperLogPO commodityOperLogPO);

    UserPO findById(long id);

}
