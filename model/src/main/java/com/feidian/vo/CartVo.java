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
public class CartVo {

    private long id;
    private long userId;
    private long commodityId;
    private long addressId;

    private String commodityDescription;
    private BigDecimal price;
    private BigDecimal commodityNum;
    private BigDecimal totalPrice;

    private long orderStatus;


    private java.sql.Timestamp updateTime;
    private long isDeleted;

}
