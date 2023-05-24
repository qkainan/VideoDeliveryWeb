package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrder {

  private long id;
  private long PurchaseOrderId;
  private long commodityId;
  private long sellerId;
  private long buyerId;
  private long addressId;

  //5：已收货 4：待收货 3：已发货 1：待发货 0：已退款
  private long status;

  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;




}
