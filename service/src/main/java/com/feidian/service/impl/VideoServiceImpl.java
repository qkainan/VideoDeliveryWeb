package com.feidian.service.impl;

import com.feidian.mapper.VideoMapper;
import com.feidian.service.VideoService;
import com.feidian.vo.VideoVo;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

    private VideoMapper videoMapper;

    @Override
    public void uploadVideo(VideoVo videoVo) {
        videoMapper.insertVideo(videoVo);
    }
}
