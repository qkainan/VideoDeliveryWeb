package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {

    private long id;
    private String videoName;
    private String videoType;
    private String videoDataUrl;
    private String coverUrl;

    private String videoDescription;


    private long videoStatus;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private long isDelete;

}
