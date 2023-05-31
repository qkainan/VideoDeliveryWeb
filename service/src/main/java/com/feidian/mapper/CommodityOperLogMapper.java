package com.feidian.mapper;

import com.feidian.po.CommodityOperLogPO;
import com.feidian.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommodityOperLogMapper {

    void insertLog(CommodityOperLogPO commodityOperLogPO);

    UserPO findById(long id);
}
