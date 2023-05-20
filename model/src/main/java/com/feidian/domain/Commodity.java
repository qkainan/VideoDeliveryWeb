package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commodity {

  private long id;
  private String commodityName;
  private String commodityType;
  private BigDecimal price;
  private String commodityAddress;

  private String commodityDescription;
  private String coverUrl;

  private long commodityStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;



}
