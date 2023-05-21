package com.feidian.controller;

import com.feidian.domain.User;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.LoginLogService;
import com.feidian.service.UserService;
import com.feidian.util.AESUtil;
import com.feidian.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody String username, @RequestBody String password) throws Exception {

        if (password.length() >16 && password.length() <8 ) {
            return new ResponseResult(403, "密码不符合要求");
        }

        //密码符合要求则开始验证
        User user = userService.findByName(username);
        Long id01 = user.getId();
        String username01 = user.getUsername();

        if (!StringUtils.hasText(username01)) {
            return new ResponseResult(403, "用户名不存在");
        }

        //验证密码是否正确
        //补全用户输入的密码
        String userPwd = "";
        StringBuilder stringBuilder = new StringBuilder(password);
        if (16 > password.length()){
            for (int i = password.length() ; i < 16; i++) {
                stringBuilder = stringBuilder.append("=");
            }
        }
        userPwd = stringBuilder.toString();

        //获取解密后的密码
        String decryptUserPwd = AESUtil.decryptByAES(user.getPassword());

        if (!decryptUserPwd.equals(userPwd)) {
            user.setUserStatus(1);
            loginLogService.recordLoginLog(user.getUsername(),user.getUserStatus(),"登陆失败");
            return new ResponseResult(403, "密码不正确");
        }

        //如果正确 生成token返回,并记录日志
        Map<String, Object> map;
        map = new HashMap<>();
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(id01), null);
        map.put("token", token);
        user.setUserStatus(0);

        loginLogService.recordLoginLog(user.getUsername(),user.getUserStatus(),"登录成功");
        return new ResponseResult(200, "登录成功", map);
    }


}
