package com.feidian.mapper;

import com.feidian.domain.LoginLog;
import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginLogMapper {
    void insert(LoginLog loginLog);

    IPage selectPage(Page<LoginLog> pageParam);
}
