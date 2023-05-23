package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.User;
import com.feidian.domain.Video;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.UserService;
import com.feidian.service.VideoService;
import com.feidian.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class VideoController {

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/homerecommend")
    public ResponseResult homeRecommend(){
        List<Video> list = new ArrayList<Video>();
        for (Integer id:videoService.homeRecommend()) {
            list.add(videoService.findByVideoId(id));
        }

        return new ResponseResult(200, "操作成功",list);
    }

    @GetMapping("/video")
    public ResponseResult geiVideoVo(Integer id){
        Video video = videoService.findByVideoId(id);
        User user = userService.findById(video.getUserId());
        List<Commodity> commodityList = commodityService.findByUserId(video.getUserId());

        VideoVo videoVo = new VideoVo(video.getId(), video.getVideoTitle(), user.getId(),
                user.getUsername(), video.getDataUrl(), video.getCoverUrl(), video.getVideoDescription(),
                video.getCreateTime(), commodityList);

        return new ResponseResult(200,"操作成功",videoVo);
    }

}
