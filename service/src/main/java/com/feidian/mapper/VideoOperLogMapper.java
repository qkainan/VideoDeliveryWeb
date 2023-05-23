package com.feidian.mapper;


import com.feidian.domain.User;
import com.feidian.domain.VideoOperLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VideoOperLogMapper {

    void insertLog(VideoOperLog videoOperLog);

    User findById(long id);
}
