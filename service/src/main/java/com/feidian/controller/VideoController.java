package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.User;
import com.feidian.domain.Video;
import com.feidian.domain.VideoCommodity;
import com.feidian.resolver.CurrentUserId;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.UserService;
import com.feidian.service.VideoCommodityService;
import com.feidian.service.VideoService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.DisplayVideoVo;
import com.feidian.vo.UploadVideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private UserService userService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private VideoCommodityService videoCommodityService;

    @GetMapping("/getHomeRecommend")
    public ResponseResult homeRecommend(){
        List<Video> list = new ArrayList<>();
        for (Integer id:videoService.homeRecommend()) {
            list.add(videoService.findByVideoId(id));
        }
        return new ResponseResult(200, "操作成功",list);
    }


    //Todo
    @GetMapping("/getDisplayVideo/{id}")
    public ResponseResult getDisplayVideoVo(@PathVariable("id") long id){
        Video video = videoService.findByVideoId(id);
        User user = userService.findById(video.getUserId());

        List<VideoCommodity> videoCommodityList = videoCommodityService.findByVideoId(id);
        List<Commodity> commodityList = new ArrayList<>();

        for (VideoCommodity vc:videoCommodityList) {
            Commodity byCommodityId = commodityService.findByCommodityId(vc.getCommodityId());
            commodityList.add(byCommodityId);
        }

        DisplayVideoVo displayVideoVo = new DisplayVideoVo(video.getId(), video.getVideoTitle(), user.getId(),
                user.getUsername(), video.getDataUrl(), video.getCoverUrl(),
                video.getVideoDescription(), video.getCreateTime(), commodityList);

        return new ResponseResult(200,"操作成功",displayVideoVo);
    }

    @PostMapping("/postUploadVideo")
    public ResponseResult uploadVideo(@RequestBody UploadVideoVo uploadVideoVo,
                                         @RequestPart("dataFile") MultipartFile dataFile,
                                         @RequestPart("coverFile") MultipartFile coverFile){

        long userId = JwtUtil.getUserId();
        long videoId = uploadVideoVo.getId();

        String videoDataUrl = "";
        String videoCoverUrl = "";

        //Todo 最好放在配置文件
        // 定义保存路径
        String uploadVideoCoverDir = "C:/uploads/videos/cover/";
        uploadVideoFile(coverFile,uploadVideoCoverDir);
        videoCoverUrl = uploadVideoFile(coverFile,uploadVideoCoverDir);
        uploadVideoVo.setCoverUrl(videoCoverUrl);

        String uploadVideoDataDir = "C:/uploads/videos/data/";
        uploadVideoFile(dataFile,uploadVideoDataDir);
        videoDataUrl = uploadVideoFile(dataFile,uploadVideoDataDir);
        uploadVideoVo.setDataUrl(videoDataUrl);
        uploadVideoVo.setVideoName(dataFile.getOriginalFilename());

        uploadVideoVo.setUserId(userId);

        Video video = new Video(videoId, uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);

        videoService.insertVideo(video);

        return new ResponseResult(200,"操作成功");
    }

    @PostMapping("/postUploadVideoCommodity")
    public ResponseResult postUploadVideoCommodity(@RequestBody UploadVideoVo uploadVideoVo){
        long userId = JwtUtil.getUserId();
        Video video = videoService.findByVideoId(uploadVideoVo.getId());

        //将商品安排到video推荐商品里
        for (Commodity c : uploadVideoVo.getCommodityList()) {
            VideoCommodity videoCommodity = new VideoCommodity(userId, uploadVideoVo.getId(), c.getId(),
                    video.getVideoStatus());
            videoCommodityService.insertVideoCommodity(videoCommodity);
        }

        return new ResponseResult(200,"操作成功");
    }


    @PostMapping ("/postDeleteVideo")
    public ResponseResult deleteVideo(long videoId){
        videoService.deleteVideo(videoId);
        return new ResponseResult(200, "操作成功");
    }

    @PutMapping("/putUpdateVideoMsg")
    public ResponseResult putUpdateVideoMsg(@RequestBody UploadVideoVo uploadVideoVo) {
        Video video = new Video(uploadVideoVo.getId(),uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(),
                uploadVideoVo.getVideoDescription(), uploadVideoVo.getCoverUrl());
        videoService.updateVideoMsg(video);
        return new ResponseResult(200,"操作成功");
    }

    @PutMapping("/putUpdateVideoCommodityMsg")
    public ResponseResult putUpdateVideoCommodityMsg(@RequestBody UploadVideoVo uploadVideoVo){

        for (Commodity c:uploadVideoVo.getCommodityList()) {
            VideoCommodity videoCommodity = new VideoCommodity(uploadVideoVo.getId(),c.getId());
            videoCommodityService.updateVideoCommodityMsg(videoCommodity);
        }
        return new ResponseResult(200,"操作成功");
    }

    public String uploadVideoFile(MultipartFile file,String uploadDir) {

        // 处理文件上传逻辑
        // 进行视频文件的保存、处理等操作
        // 返回相应的结果

        if (file.isEmpty()) {
            return  "0";
        }

        try {
            // 定义保存路径
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

            return filePath;
        } catch (IOException e) {
            return e.getMessage();
        }
    }


}
