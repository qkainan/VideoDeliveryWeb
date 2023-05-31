package com.feidian.service.impl;


import com.feidian.po.UserPO;
import com.feidian.po.VideoOperLogPO;
import com.feidian.mapper.VideoOperLogMapper;

import com.feidian.service.VideoOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoOperLogServiceImpl implements VideoOperLogService {
    @Autowired
    private VideoOperLogMapper videoOperLogMapper;

    @Override
    public void saveLog(VideoOperLogPO videoOperLogPO) {
        videoOperLogMapper.insertLog(videoOperLogPO);
    }

    @Override
    public UserPO findById(long id) {
        return videoOperLogMapper.findById(id);
    }
}
