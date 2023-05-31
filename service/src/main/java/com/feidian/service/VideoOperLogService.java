package com.feidian.service;

import com.feidian.po.UserPO;
import com.feidian.po.VideoOperLogPO;

public interface VideoOperLogService {

    void saveLog(VideoOperLogPO videoOperLogPO);

    UserPO findById(long id);
}
