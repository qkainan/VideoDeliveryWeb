package com.feidian.vo;

import com.feidian.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpMsg {

    private Integer id;
    private String username;
    private String password;

    private String rePwd;
    private String verifyCode;
    private String emailAddress;
}
