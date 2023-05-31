package com.feidian.mapper;

import com.feidian.po.VideoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {

    void deleteVideo(long videoId);

    void insertVideo(VideoPO videoPO);

    void findByVideoName();

    VideoPO findByVideoId(@Param("videoId") long videoId);

    List<VideoPO> findByUserId(long userId);

    void updateVideoMsg(VideoPO videoPO);
}
