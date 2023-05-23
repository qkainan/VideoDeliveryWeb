package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.User;
import com.feidian.domain.Video;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.UserService;
import com.feidian.service.VideoService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    public ResponseResult getVideoVo(Integer id){
        Video video = videoService.findByVideoId(id);
        User user = userService.findById(video.getUserId());
        List<Commodity> commodityList = commodityService.findByUserId(video.getUserId());

        VideoVo videoVo = new VideoVo(video.getId(), video.getVideoTitle(), user.getId(),
                user.getUsername(), video.getDataUrl(), video.getCoverUrl(), video.getVideoDescription(),
                video.getCreateTime(), commodityList);

        return new ResponseResult(200,"操作成功",videoVo);
    }

    @PostMapping("/uploadVideo")
    public ResponseResult uploadVideo(@RequestBody VideoVo videoVo,@RequestPart("file") MultipartFile file){
        long userId = JwtUtil.getUserId();


//        videoVo.setUserId(userId);
//        videoVo.setVideoName(file.getOriginalFilename());
//
//        Video video = new Video();
//        videoService.insertVideo(video);
//        uploadVideoFile(file);
//        return new ResponseResult(200,"操作成功");
    }


    public ResponseResult uploadVideoFile(@RequestPart("file") MultipartFile file) {

        // 处理文件上传逻辑
        // 进行视频文件的保存、处理等操作
        // 返回相应的结果

        if (file.isEmpty()) {
            return new ResponseResult(403,"所传文件为空");
        }

        try {
            // 定义保存路径
            String uploadDir = "D:/uploadVideos/";
            // 创建保存目录（如果不存在）
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 生成保存文件的路径
            String filePath = uploadDir + file.getOriginalFilename();
            // 保存文件
            file.transferTo(new File(filePath));

            // 在此可以对文件进行进一步处理，例如调用视频处理库进行处理操作

            return new ResponseResult(200,"上传成功");
        } catch (IOException e) {
            return new ResponseResult(500,"上传失败",e.getMessage());
        }
    }

}
