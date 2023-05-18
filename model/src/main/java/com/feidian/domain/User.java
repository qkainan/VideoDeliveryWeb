package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

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


    public User(long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;



    }

    public User(long id, String username, String password,  String emailAddress) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;

    }
}
