package com.feidian.service;



public interface LoginLogService {

    void recordLoginLog(String username, Long status, String message);


}
