package com.feidian.mapper;

import com.feidian.po.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<UserPO> findAll();

    UserPO findById(long id);

    UserPO findByName(String username);

    void insertUser(UserPO userPO);

    void signUp(UserPO userPO);

    void deleteUser(long id);

    void updateUser(UserPO userPO);

    void updateUserDescription(String description);
}
