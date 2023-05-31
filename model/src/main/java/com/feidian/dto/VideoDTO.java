package com.feidian.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO {
    private long videoId;
    private long userId;
    private List<Long> commodityIdList;

    private String videoName;
    private String videoTitle;
    private String videoType;
    private String videoDescription;


    public VideoDTO(long videoId, long userId, List<Long> commodityIdList) {
        this.videoId = videoId;
        this.userId = userId;
        this.commodityIdList = commodityIdList;
    }


}
