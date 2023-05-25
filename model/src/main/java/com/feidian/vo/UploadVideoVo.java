package com.feidian.vo;

import com.feidian.domain.Commodity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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

    private List<Commodity> commodityList;
    private String coverUrl;
    private String dataUrl;


}
