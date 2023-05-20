package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpVo {

    private Long id;
    private String username;
    private String password;

    private String rePwd;
    private String verifyCode;
    private String emailAddress;
}
