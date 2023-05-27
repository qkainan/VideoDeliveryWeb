package com.feidian.service.impl;

import com.feidian.domain.Address;
import com.feidian.domain.User;
import com.feidian.mapper.AddressMapper;
import com.feidian.mapper.UserMapper;
import com.feidian.service.UserService;
import com.feidian.vo.UserPersonalInformationVo;
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
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(long id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public void signUp(User user) {
        userMapper.signUp(user);
    }

    @Override
    public void deleteUser(long id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateUserDescription(String description) {
        userMapper.updateUserDescription(description);
    }

    @Override
    public void updateUserPersonalInformation(UserPersonalInformationVo userPersonalInformationVo) {
        User user = new User(userPersonalInformationVo.getId(),userPersonalInformationVo.getUsername(),userPersonalInformationVo.getPassword(),
                userPersonalInformationVo.getPhone(),userPersonalInformationVo.getHeadUrl(),userPersonalInformationVo.getUserDescription(),
                userPersonalInformationVo.getEmailAddress());

        userMapper.updateUser(user);
    }

    @Override
    public Address findByAddressId(long addressId) {
        return addressMapper.findByAddressId(addressId);
    }


}
