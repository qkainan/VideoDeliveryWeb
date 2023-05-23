package com.feidian.service;

import com.feidian.domain.User;
import com.feidian.domain.VideoOperLog;

public interface VideoOperLogService {

    void saveLog(VideoOperLog videoOperLog);

    User findById(long id);
}
