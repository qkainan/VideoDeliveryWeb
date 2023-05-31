package com.feidian.service.impl;

import com.feidian.po.LoginLogPO;
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
        LoginLogPO loginLogPO = new LoginLogPO();
        loginLogPO.setUsername(username);
        loginLogPO.setStatus(status);
        loginLogPO.setMsg(message);
        loginLogMapper.insert(loginLogPO);
    }



}
