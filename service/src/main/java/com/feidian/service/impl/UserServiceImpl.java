package com.feidian.service.impl;

import com.feidian.po.AddressPO;
import com.feidian.po.UserPO;
import com.feidian.mapper.AddressMapper;
import com.feidian.mapper.UserMapper;
import com.feidian.service.UserService;
import com.feidian.vo.UserPersonalInformationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;



    @Override
    public List<UserPO> findAll() {
        return userMapper.findAll();
    }

    @Override
    public UserPO findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public UserPO findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public void insertUser(UserPO userPO) {
        userMapper.insertUser(userPO);
    }

    @Override
    public void signUp(UserPO userPO) {
        userMapper.signUp(userPO);
    }

    @Override
    public void deleteUser(long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void updateUser(UserPO userPO) {
        userMapper.updateUser(userPO);
    }

    @Override
    public void updateUserDescription(String description) {
        userMapper.updateUserDescription(description);
    }

    @Override
    public void updateUserPersonalInformation(UserPersonalInformationVO userPersonalInformationVo) {
        UserPO userPO = new UserPO(userPersonalInformationVo.getId(),userPersonalInformationVo.getUsername(),userPersonalInformationVo.getPassword(),
                userPersonalInformationVo.getPhone(),userPersonalInformationVo.getHeadUrl(),userPersonalInformationVo.getUserDescription(),
                userPersonalInformationVo.getEmailAddress());

        userMapper.updateUser(userPO);
    }

    @Override
    public AddressPO findByAddressId(long addressId) {
        return addressMapper.findByAddressId(addressId);
    }


}
