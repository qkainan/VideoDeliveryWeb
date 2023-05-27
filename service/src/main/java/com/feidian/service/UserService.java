package com.feidian.service;

import com.feidian.domain.Address;
import com.feidian.domain.User;
import com.feidian.vo.UserPersonalInformationVo;


import java.util.List;

public interface UserService {


    List<User> findAll();

    User findById(long id);

    User findByName(String username);

    void insertUser(User user);

    void signUp(User user);

    void deleteUser(long id);

    void updateUser(User user);

    void updateUserDescription(String description);

    void updateUserPersonalInformation(UserPersonalInformationVo userPersonalInformationVo);

    Address findByAddressId(long addressId);
}
