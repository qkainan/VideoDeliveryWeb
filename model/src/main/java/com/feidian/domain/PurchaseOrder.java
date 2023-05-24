package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseOrder {

    private long id;
    private long purchaseOrderId;
    private long buyerId;
    private long sellerId;
    private long commodityId;

    private long commodityNum;

    private BigDecimal paymentAmount;

    //5：已收货 4：待收货 3：已发货 1：待发货 0：已退款
    private long status;

    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private long isDeleted;


}
