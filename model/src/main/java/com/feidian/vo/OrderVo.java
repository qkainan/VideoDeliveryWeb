package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {
    private long id;
    private String commodityName;
    private String commodityType;
    private BigDecimal price;
    private String commodityAddress;

    private String commodityDescription;
    private String coverUrl;

}
