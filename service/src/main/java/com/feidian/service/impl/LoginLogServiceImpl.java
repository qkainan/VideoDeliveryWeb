package com.feidian.service.impl;

import com.feidian.domain.LoginLog;
import com.feidian.mapper.LoginLogMapper;

import com.feidian.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public void recordLoginLog(String username, Long status, String message) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setStatus(status);
        loginLog.setMsg(message);
        loginLogMapper.insert(loginLog);
    }



}
