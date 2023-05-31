package com.feidian.controller;

import com.feidian.po.UserPO;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @Transactional
    public ResponseResult findAll() {
        return new ResponseResult<>(200, "操作成功", userService.findAll());
    }

    @GetMapping ("/findById/{id}")
    @Transactional
    public ResponseResult findById(@PathVariable("id")long id){
        UserPO userPO = userService.findById(id);
        if (userPO == null) {
            return new ResponseResult(500, "用户不存在");
        }
        return new ResponseResult(200,"操作成功", userPO);
    }

    @GetMapping("/findByName/{name}")
    @Transactional
    public ResponseResult findByName(@PathVariable("name") String username){
        UserPO userPO = userService.findByName(username);
        if (userPO == null) {
            return new ResponseResult(500, "用户不存在");
        }
        return new ResponseResult<>(200 , "操作成功", userPO);
    }

    @PostMapping("/insertUser")
    @Transactional
    public ResponseResult insertUser(UserPO userPO){
        userService.insertUser(userPO);
        return new ResponseResult(200, "操作成功");
    }


    @PostMapping ("/deleteUser")
    @Transactional
    public ResponseResult deleteUser(long id){
        userService.deleteUser(id);
        return new ResponseResult(200, "操作成功");
    }

    @PutMapping("/updateUser")
    @Transactional
    public ResponseResult updateUser(@RequestBody UserPO userPO){
        userService.updateUser(userPO);
        return new ResponseResult(200,"操作成功");
    }

}
