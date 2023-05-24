package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadCommodityVo {

    private long id;
    private long userId;

    private String commodityName;
    private String commodityType;
    private BigDecimal price;
    private String commodityDescription;
    private String commodityAddress;
    private String coverUrl;

}
