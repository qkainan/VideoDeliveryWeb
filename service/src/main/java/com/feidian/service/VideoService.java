package com.feidian.service;

import com.feidian.domain.Video;
import com.feidian.vo.VideoVo;

import java.util.List;


public interface VideoService {

    void uploadVideo(VideoVo videoVo);

    Integer[] homeRecommend();

    Video findByVideoId(Integer id);

    List<Video> findByUserId(long userId);
}
