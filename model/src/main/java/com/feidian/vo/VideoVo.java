package com.feidian.vo;

import com.feidian.domain.Commodity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoVo {

    private long videoId;
    private String videoTitle;

    private long userId;

    private String videoDataUrl;
    private String videoCoverUrl;
    private String videoDescription;
    private java.sql.Timestamp createTime;


    private List<Commodity> commodityList;

}
