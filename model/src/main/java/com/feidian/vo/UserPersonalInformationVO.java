package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPersonalInformationVO {

    private long id;
    private String username;
    private String password;

    private Integer phone;
    private String headUrl;
    private String userDescription;
    private String emailAddress;



}
