package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoVo {
    private long id;
    private String videoName;
    private String videoType;
    private String videoDataUrl;
    private String coverUrl;

    private String videoDescription;

    private long userId;
    private long commodityId;


}
