package com.feidian.controller;

import com.feidian.domain.User;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public ResponseResult findAll() {
        return new ResponseResult<>(200, "操作成功", userService.findAll());
    }

    @PostMapping("/findById/{id}")
    public ResponseResult findById(@PathVariable("id")Integer id){
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseResult(500, "User does not exist");
        }
        return new ResponseResult(200,"操作成功",user);
    }

    @PostMapping("/findByName/{name}")
    public ResponseResult findByName(@PathVariable("name") String username){
        User user = userService.findByName(username);
        if (user == null) {
            return new ResponseResult(500, "User does not exist");
        }
        return new ResponseResult<>(200 , "操作成功", user);
    }

    @PostMapping("/insertUser")
    public ResponseResult insertUser(User user){
        userService.insertUser(user);
        return new ResponseResult(200, "操作成功");
    }

    @PostMapping("/deleteUser/{id}")
    public ResponseResult deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
        return new ResponseResult(200, "操作成功");
    }

    @PutMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return new ResponseResult(200,"操作成功");
    }

}
