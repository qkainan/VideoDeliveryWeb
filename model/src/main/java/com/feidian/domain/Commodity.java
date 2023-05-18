package com.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commodity {

  private long id;
  private String commodityName;
  private String commodityType;
  private double price;
  private String commodityAddress;

  private String commodityDescription;
  private String coverUrl;

  private long commodityStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;



}
