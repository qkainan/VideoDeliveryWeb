package com.feidian.service;

import com.feidian.domain.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findById(Integer id);

    User findByName(String username);

    void insertUser(User user);

    void signUp(User user);

    void deleteUser(Integer id);

    void updateUser(User user);

}
