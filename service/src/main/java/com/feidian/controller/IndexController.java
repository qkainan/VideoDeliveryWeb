package com.feidian.controller;

import com.feidian.dto.SignupDTO;
import com.feidian.po.UserPO;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.LoginLogService;
import com.feidian.service.UserService;
import com.feidian.util.AESUtil;
import com.feidian.util.EmailUtil;
import com.feidian.util.JwtUtil;
import com.feidian.util.VerifyCode;
import com.feidian.vo.LoginVO;
import com.feidian.vo.SignUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    String verifyCode = new VerifyCode().setVerifyCode();

    //快速注册
    @Transactional
    @PostMapping("/postFastSignup")
    public ResponseResult fastSignup(@RequestBody SignupDTO signUpMsg) throws Exception {
        //Todo 校验密码是否符合强度要求
        // 1.只能包含英文字母、阿拉伯数字和下划线
        // 2.密码长度在8到25之间
        // 3.再次输入密码需与第一次输入的密码一致
        // 4.加密密码

        String regexPwd = "\\w{8,25}";

        if (signUpMsg.getPassword().matches(regexPwd) == false) {
            return new ResponseResult(403,"密码不符合要求");
        }

        if (!signUpMsg.getPassword().equals(signUpMsg.getRePwd())) {
            return new ResponseResult(403,"第二次输入密码与第一次不同");
        }

        //加密密码并创建用户
        //补全16位
        String encryptUserPwd = getEncryptUserPwd(signUpMsg.getPassword());
        UserPO userPO = new UserPO(signUpMsg.getId(), signUpMsg.getUsername(), encryptUserPwd);

        userService.signUp(userPO);
        return new ResponseResult(200,"操作成功");
    }

    //邮箱注册
    @Transactional
    @PostMapping("/postEmailSignup")
    public ResponseResult emailSignup(@RequestBody SignUpVO signUpVo) throws Exception {
        //Todo 校验密码是否符合强度要求
        // 1.只能包含英文字母、阿拉伯数字和下划线
        // 2.密码长度在8到16之间
        // 3.再次输入密码需与第一次输入的密码一致
        // 4.加密密码
        // 5.邮箱验证

        String regexPwd = "\\w{8,16}";

        if (false == signUpVo.getPassword().matches(regexPwd)) {
            return new ResponseResult(403,"密码不符合要求");
        }

        if (!signUpVo.getPassword().equals(signUpVo.getRePwd())) {
            return new ResponseResult(403, "密码不正确");
        }


        //验证邮箱验证码
        Boolean verifyResult = verifyCode.equals(signUpVo.getVerifyCode());

        if (false == verifyResult) {
            return new  ResponseResult(403,"验证码错误");
        }


        //加密密码并创建用户
        //补全16位
        String encryptUserPwd = getEncryptUserPwd(signUpVo.getPassword());
        UserPO userPO = new UserPO(signUpVo.getId(), signUpVo.getUsername(), encryptUserPwd);

        userService.signUp(userPO);
        return new ResponseResult(200,"操作成功");
    }

    //加密用户密码
    public String getEncryptUserPwd(String password) throws Exception {
        String userPwd = "";
        StringBuilder stringBuilder = new StringBuilder(password);
        //补全
        if (16 > password.length()){
            for (int i = password.length() ; i < 16; i++) {
                stringBuilder = stringBuilder.append("=");
            }
        }

        userPwd = stringBuilder.toString();
        String encryptUserPwd = AESUtil.encryptByAES(userPwd);

        return encryptUserPwd;
    }


    //发送验证码
    @Transactional
    @PostMapping("/postVerify")
    public ResponseResult postVerify(@RequestBody SignUpVO signUpVo) {

        String regexEmailAddress = "\\w+@[\\w&&[^_]]{2,7}(\\.[a-zA-Z]{2,4}){1,3}";

        if (!signUpVo.getEmailAddress().matches(regexEmailAddress)) {
            return new ResponseResult(403,"密码格式不正确");
        }

        //发送验证码
        EmailUtil.sendEmail(signUpVo.getEmailAddress(), verifyCode);

        return new ResponseResult(200,"验证码发送成功");
    }


    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/postLogin")
    @Transactional
    public ResponseResult login(@RequestBody LoginVO loginVo) throws Exception {

        if (loginVo.getPassword().length() >16 && loginVo.getPassword().length() <8 ) {
            return new ResponseResult(403, "密码不符合要求");
        }

        //密码符合要求则开始验证
        UserPO userPO = userService.findByName(loginVo.getUsername());
        Long id01 = userPO.getId();
        String username01 = userPO.getUsername();

        if (!StringUtils.hasText(username01)) {
            return new ResponseResult(403,"用户名不存在");
        }

        //验证密码是否正确
        //补全用户输入的密码
        String userPwd = "";
        StringBuilder stringBuilder = new StringBuilder(loginVo.getPassword());
        if (16 > loginVo.getPassword().length()){
            for (int i = loginVo.getPassword().length() ; i < 16; i++) {
                stringBuilder = stringBuilder.append("=");
            }
        }
        userPwd = stringBuilder.toString();

        //获取解密后的密码
        String decryptUserPwd = AESUtil.decryptByAES(userPO.getPassword());

        if (!decryptUserPwd.equals(userPwd)) {
            userPO.setUserStatus(1);
            loginLogService.recordLoginLog(userPO.getUsername(), userPO.getUserStatus(),"登陆失败");
            return new ResponseResult(403,"密码不正确");
        }

        //如果正确 生成token返回,并记录日志
        Map<String, Object> map;
        map = new HashMap<>();
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(id01), null);
        map.put("Authorization", token);
        userPO.setUserStatus(0);

        loginLogService.recordLoginLog(userPO.getUsername(), userPO.getUserStatus(),"登录成功");
        return new ResponseResult(200, "登录成功", map);
    }

}
