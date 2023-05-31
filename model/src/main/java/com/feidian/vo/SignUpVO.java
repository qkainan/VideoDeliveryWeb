package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpVO {

    private long id;
    private String username;
    private String password;

    private String rePwd;
    private String verifyCode;
    private String emailAddress;
}
