package com.feidian.service;

import com.feidian.domain.Video;
import com.feidian.vo.DisplayVideoVo;

import java.util.List;


public interface VideoService {

    void insertVideo(Video videoVo);

    Integer[] homeRecommend();

    Video findByVideoId(long id);

    List<Video> findByUserId(long userId);


    void deleteVideo(long videoId);

    void updateVideoMsg(Video video);
}
