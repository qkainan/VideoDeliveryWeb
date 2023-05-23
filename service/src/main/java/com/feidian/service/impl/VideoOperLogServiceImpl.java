package com.feidian.service.impl;


import com.feidian.domain.User;
import com.feidian.domain.VideoOperLog;
import com.feidian.mapper.VideoOperLogMapper;

import com.feidian.service.VideoOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoOperLogServiceImpl implements VideoOperLogService {
    @Autowired
    private VideoOperLogMapper videoOperLogMapper;

    @Override
    public void saveLog(VideoOperLog videoOperLog) {
        videoOperLogMapper.insertLog(videoOperLog);
    }

    @Override
    public User findById(long id) {
        return videoOperLogMapper.findById(id);
    }
}
