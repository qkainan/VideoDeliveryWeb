package com.feidian.po;

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
public class UserPO {

    private long id;
    private String username;
    private String password;

    private Integer phone;
    private String headUrl;
    private String userDescription;
    private String emailAddress;

    private long userStatus;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private long isDeleted;


    public UserPO(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserPO(long id, String username, String password, String emailAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public UserPO(long id, String username, String password, Integer phone,
                  String headUrl, String userDescription, String emailAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.headUrl = headUrl;
        this.userDescription = userDescription;
    }
}
