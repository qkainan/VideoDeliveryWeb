package com.feidian.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommodityOperLog {

  private long id;
  private String businessType;
  private String method;
  private String requestMethod;
  private String operUserename;
  private String operUrl;
  private String operParam;
  private String jsonResult;
  private long status;
  private String errorMsg;

  private java.sql.Timestamp operTime;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;



}
