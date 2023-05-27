package com.feidian.mapper;

import com.feidian.domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {

    void deleteVideo(long videoId);

    void insertVideo(Video video);

    void findByVideoName();

    Video findByVideoId(@Param("videoId") long videoId);

    List<Video> findByUserId(long userId);

    void updateVideoMsg(Video video);
}
