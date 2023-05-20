package com.feidian.controller;

import com.feidian.domain.User;
import com.feidian.responseResult.ResponseResult;
import com.feidian.vo.SignUpVo;
import com.feidian.service.UserService;
import com.feidian.util.AESUtil;
import com.feidian.util.EmailUtil;
import com.feidian.util.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SignUpController {

    @Autowired
    private UserService userService;

    String verifyCode = new VerifyCode().setVerifyCode();

    //快速注册
    @PostMapping("/postFastSignUp")
    public ResponseResult fastSignUp(@RequestBody SignUpVo signUpMsg) throws Exception {
        //Todo 校验密码是否符合强度要求
        // 1.只能包含英文字母、阿拉伯数字和下划线
        // 2.密码长度在8到25之间
        // 3.再次输入密码需与第一次输入的密码一致
        // 4.加密密码

        String regexPwd = "\\w{8,25}";

        if (signUpMsg.getPassword().matches(regexPwd) == false) {
            return new ResponseResult(403, "输入密码不符合要求");
        }

        if (!signUpMsg.getPassword().equals(signUpMsg.getRePwd())) {
            return new ResponseResult(403, "第二次输入密码与第一次不同");
        }

        //加密密码并创建用户
        //补全16位
        String encryptUserPwd = getEncryptUserPwd(signUpMsg.getPassword());
        User user = new User(signUpMsg.getId(), signUpMsg.getUsername(), encryptUserPwd);

        userService.signUp(user);
        return new ResponseResult(200, "操作成功");
    }

    //邮箱注册
    @PostMapping("/postEmailSignUp")
    public ResponseResult emailSignUp(@RequestBody SignUpVo signUpVo) throws Exception {
        //Todo 校验密码是否符合强度要求
        // 1.只能包含英文字母、阿拉伯数字和下划线
        // 2.密码长度在8到16之间
        // 3.再次输入密码需与第一次输入的密码一致
        // 4.加密密码
        // 5.邮箱验证

        String regexPwd = "\\w{8,16}";

        if (false == signUpVo.getPassword().matches(regexPwd)) {
            return new ResponseResult(403, "输入密码不符合要求");
        }

        if (!signUpVo.getPassword().equals(signUpVo.getRePwd())) {
            return new ResponseResult(403, "第二次输入密码与第一次不同");
        }


        //验证邮箱验证码
        Boolean verifyResult = verifyCode.equals(signUpVo.getVerifyCode());

        if (false == verifyResult) {
            return new ResponseResult(403, "验证码错误");
        }


        //加密密码并创建用户
        //补全16位
        String encryptUserPwd = getEncryptUserPwd(signUpVo.getPassword());
        User user = new User(signUpVo.getId(), signUpVo.getUsername(), encryptUserPwd);

        userService.signUp(user);
        return new ResponseResult(200, "操作成功");
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

    //邮箱验证
    @PostMapping("/postVerify")
    public ResponseResult postVerify(@RequestBody SignUpVo signUpVo) {

        String regexEmailAddress = "\\w+@[\\w&&[^_]]{2,7}(\\.[a-zA-Z]{2,4}){1,3}";

        if (!signUpVo.getEmailAddress().matches(regexEmailAddress)) {
            return new ResponseResult(403, "邮箱格式不正确", signUpVo.getEmailAddress());
        }

        //发送验证码
        EmailUtil.sendEmail(signUpVo.getEmailAddress(), verifyCode);

        return new ResponseResult(200, "发送验证码成功");
    }
}
