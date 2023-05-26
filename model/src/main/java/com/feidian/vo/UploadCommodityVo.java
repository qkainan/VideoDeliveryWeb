package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
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
    private List<String> imageUrl;

}
