package com.feidian.mapper;

import com.feidian.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(Integer id);

    User findByName(String username);

    void insertUser(User user);

    void signUp(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

    void updateUserDescription(String description);
}
