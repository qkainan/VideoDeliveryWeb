package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHomepageVo {
    private long id;
    private String username;
    private String userDescription;

    private long videoId;
    private String videoName;
    private String videoCoverUrl;
    private String videoDescription;
    private java.sql.Timestamp videoCreateTime;

    private long commodityId;
    private String commodityName;
    private BigDecimal price;
    private String commodityDescription;
    private String commodityCoverUrl;
    private java.sql.Timestamp commodityCreateTime;

}
