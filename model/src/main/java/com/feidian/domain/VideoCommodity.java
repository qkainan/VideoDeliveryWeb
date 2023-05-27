package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoCommodity {

  private long id;
  private long userId;
  private long videoId;
  private long commodityId;

  private long videoStatus;

  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;


  public VideoCommodity(long userId, long videoId, long commodityId, long videoStatus) {
    this.userId = userId;
    this.videoId = videoId;
    this.commodityId = commodityId;
    this.videoStatus = videoStatus;
  }

  public VideoCommodity(long videoId, long commodityId) {
    this.videoId = videoId;
    this.commodityId = commodityId;
  }

}
