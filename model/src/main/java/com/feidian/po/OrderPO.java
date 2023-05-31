package com.feidian.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderPO {

  private long id;
  private long buyerId;
  private long sellerId;

  private String addressName;
  private String commodityAddress;

  //状态（5：已收货 4：代发货 3：已发货 2：代发货 0：已退款 ）
  private long orderStatus;

  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;

  public OrderPO(long id, long buyerId, long sellerId, String addressName, String commodityAddress, long orderStatus) {
    this.id = id;
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.addressName = addressName;
    this.commodityAddress = commodityAddress;
    this.orderStatus = orderStatus;
  }

}
