package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadVideoVo {

    private long id;
    private long userId;

    private String videoName;
    private String videoTitle;
    private String videoType;
    private String videoDescription;
    private String coverUrl;
    private String dataUrl;


}
