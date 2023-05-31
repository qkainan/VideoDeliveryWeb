package com.feidian.mapper;


import com.feidian.po.UserPO;
import com.feidian.po.VideoOperLogPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VideoOperLogMapper {

    void insertLog(VideoOperLogPO videoOperLogPO);

    UserPO findById(long id);
}
