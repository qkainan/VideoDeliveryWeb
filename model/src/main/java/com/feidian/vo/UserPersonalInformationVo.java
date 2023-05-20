package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonalInformationVo {

    private long id;
    private String username;
    private String password;

    private Integer phone;
    private String headUrl;
    private String userDescription;
    private String emailAddress;



}
