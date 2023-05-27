package com.feidian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

  private long id;
  private long userId;

  private String videoName;
  private String videoTitle;
  private String videoType;
  private String videoDescription;
  private String coverUrl;
  private String dataUrl;

  private long videoStatus;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;
  private long isDeleted;

  public Video( long userId, String videoName, String videoTitle, String videoType, String videoDescription, String coverUrl, String dataUrl,long videoStatus) {

    this.userId = userId;
    this.videoName = videoName;
    this.videoTitle = videoTitle;
    this.videoType = videoType;
    this.videoDescription = videoDescription;
    this.coverUrl = coverUrl;
    this.dataUrl = dataUrl;
    this.videoStatus = videoStatus;
  }

  public Video(long id, String videoTitle, String videoType, String videoDescription, String coverUrl) {
    this.id = id;
    this.videoTitle = videoTitle;
    this.videoType = videoType;
    this.videoDescription = videoDescription;
    this.coverUrl = coverUrl;

  }

}
