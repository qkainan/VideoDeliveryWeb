package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityVo {
    private long id;
    private String commodityName;
    private String commodityType;
    private double price;
    private String commodityAddress;

    private String commodityDescription;
    private String coverUrl;


}
