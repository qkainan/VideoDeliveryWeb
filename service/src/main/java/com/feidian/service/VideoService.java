package com.feidian.service;

import com.feidian.domain.Video;
import com.feidian.vo.DisplayVideoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface VideoService {

    void insertVideo(Video videoVo);

    long[] homeRecommend();

    Video findByVideoId(@Param("videoId") long videoId);

    List<Video> findByUserId(long userId);


    void deleteVideo(long videoId);

    void updateVideoMsg(Video video);
}
