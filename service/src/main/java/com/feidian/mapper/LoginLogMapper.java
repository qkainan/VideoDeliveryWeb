package com.feidian.mapper;

import com.feidian.po.LoginLogPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginLogMapper {
    void insert(LoginLogPO loginLogPO);

}
