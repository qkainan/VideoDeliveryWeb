package com.feidian.vo;

import com.feidian.domain.Commodity;
import com.feidian.domain.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideosVo {

    private List<Video> videoList;

    private List<Commodity> commodityList;

}
