package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommodityVO {
    private long id;
    private String commodityName;
    private String commodityType;
    private BigDecimal price;
    private String commodityAddress;

    private String commodityDescription;
    private String coverUrl;


}
