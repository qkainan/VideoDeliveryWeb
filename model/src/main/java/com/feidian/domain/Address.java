package com.sample;


public class Address {

  private long id;
  private String addressName;
  private long addressStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAddressName() {
    return addressName;
  }

  public void setAddressName(String addressName) {
    this.addressName = addressName;
  }


  public long getAddressStatus() {
    return addressStatus;
  }

  public void setAddressStatus(long addressStatus) {
    this.addressStatus = addressStatus;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }


  public long getIsDeleted() {
    return isDeleted;
  }

  public void setIsDeleted(long isDeleted) {
    this.isDeleted = isDeleted;
  }

}
