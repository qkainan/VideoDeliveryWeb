package com.feidian.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
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

    //Todo 商品id 数组形式
    private String coverUrl;
    private String dataUrl;


}
