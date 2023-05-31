package com.feidian.service;

import com.feidian.po.AddressPO;
import com.feidian.po.UserPO;
import com.feidian.vo.UserPersonalInformationVO;


import java.util.List;

public interface UserService {


    List<UserPO> findAll();

    UserPO findById(long id);

    UserPO findByName(String username);

    void insertUser(UserPO userPO);

    void signUp(UserPO userPO);

    void deleteUser(long id);

    void updateUser(UserPO userPO);

    void updateUserDescription(String description);

    void updateUserPersonalInformation(UserPersonalInformationVO userPersonalInformationVo);

    AddressPO findByAddressId(long addressId);
}
