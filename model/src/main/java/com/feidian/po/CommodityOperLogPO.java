package com.feidian.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommodityOperLogPO {

  private long id;
  private String businessType;
  private String method;
  private String requestMethod;
  private String operUserName;
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