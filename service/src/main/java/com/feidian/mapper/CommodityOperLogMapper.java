package com.feidian.mapper;

import com.feidian.domain.CommodityOperLog;
import com.feidian.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CommodityOperLogMapper {

    void insertLog(CommodityOperLog commodityOperLog);

    User findById(long id);
}
