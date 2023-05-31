package com.feidian.controller;

import com.feidian.po.CommodityPO;
import com.feidian.po.UserPO;
import com.feidian.po.VideoPO;
import com.feidian.po.VideoCommodityPO;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.UserService;
import com.feidian.service.VideoCommodityService;
import com.feidian.service.VideoService;
import com.feidian.util.JwtUtil;
import com.feidian.util.fileUploadUtil;
import com.feidian.dto.DataAndCoverResource;
import com.feidian.vo.DisplayVideoVO;
import com.feidian.vo.UploadVideoVO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Transactional
    @GetMapping("/getHomeRecommend")
    public ResponseResult homeRecommend() throws IOException, URISyntaxException {
        List<VideoPO> list = new ArrayList<>();

        HashMap<Long,DataAndCoverResource> map = new HashMap<>();

        for (long videoId:videoService.homeRecommend()) {
            VideoPO videoPO = videoService.findByVideoId(videoId);
            list.add(videoPO);
            DataAndCoverResource dataAndCoverResource =new DataAndCoverResource(fileUploadUtil.getFileVideo(videoPO.getDataUrl()).getFileByte(),
                    fileUploadUtil.getFileImage(videoPO.getCoverUrl()).getFileByte());
            map.put(videoPO.getId(),dataAndCoverResource);
        }
        return new ResponseResult(200, "操作成功",map);
    }


    @Transactional
    @GetMapping("/getDisplayVideo")
    public ResponseResult getDisplayVideoVo(long id) throws IOException, URISyntaxException {
        VideoPO videoPO = videoService.findByVideoId(id);
        UserPO userPO = userService.findById(videoPO.getUserId());

        List<VideoCommodityPO> videoCommodityPOList = videoCommodityService.findByVideoId(id);
        List<CommodityPO> commodityPOList = new ArrayList<>();

        for (VideoCommodityPO vc: videoCommodityPOList) {
            CommodityPO byCommodityIdPO = commodityService.findByCommodityId(vc.getCommodityId());
            commodityPOList.add(byCommodityIdPO);
        }

        DisplayVideoVO displayVideoVo = new DisplayVideoVO(videoPO.getId(), videoPO.getVideoTitle(), userPO.getId(),
                userPO.getUsername(), videoPO.getDataUrl(), videoPO.getCoverUrl(),
                videoPO.getVideoDescription(), videoPO.getCreateTime(), commodityPOList);

        DataAndCoverResource dataAndCoverResource = new DataAndCoverResource(
                fileUploadUtil.getFileVideo(displayVideoVo.getVideoDataUrl()).getFileByte(),
                fileUploadUtil.getFileImage(displayVideoVo.getVideoCoverUrl()).getFileByte());

        HashMap<DisplayVideoVO, DataAndCoverResource> map = new HashMap<>();
        map.put(displayVideoVo,dataAndCoverResource);
        return new ResponseResult(200,"操作成功",fileUploadUtil.getFileVideo(displayVideoVo.getVideoDataUrl()));
    }
    @Transactional
    @PostMapping("/postUploadVideo")
    public ResponseResult uploadVideo( @RequestPart("uploadVideoVo") UploadVideoVO uploadVideoVo,
                                       @RequestPart("dataFile") MultipartFile dataFile,
                                       @RequestPart("coverFile") MultipartFile coverFile){

        long userId = JwtUtil.getUserId();

        String videoDataUrl = "";
        String videoCoverUrl = "";

        //Todo 最好放在配置文件
        // 定义保存路径
        String uploadVideoCoverDir = "D:/uploads/videos/cover/";
        uploadVideoFile(coverFile,uploadVideoCoverDir);
        videoCoverUrl = uploadVideoFile(coverFile,uploadVideoCoverDir);
        uploadVideoVo.setCoverUrl(videoCoverUrl);

        String uploadVideoDataDir = "D:/uploads/videos/data/";
        uploadVideoFile(dataFile,uploadVideoDataDir);
        videoDataUrl = uploadVideoFile(dataFile,uploadVideoDataDir);
        uploadVideoVo.setDataUrl(videoDataUrl);
        uploadVideoVo.setVideoName(dataFile.getOriginalFilename());
        uploadVideoVo.setVideoName(dataFile.getOriginalFilename());

        uploadVideoVo.setUserId(userId);

        VideoPO videoPO = new VideoPO(uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);

        videoService.insertVideo(videoPO);

        return new ResponseResult(200,"操作成功");
    }


//    @PostMapping("/postUploadVideoVo")
//    public ResponseResult uploadVideo( @RequestPart("uploadVideoVo") UploadVideoVo uploadVideoVo){
//        Video video = new Video(uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
//                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
//                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);
//        videoService.insertVideo(video);
//        return new ResponseResult<>(200,"上传视频信息成功");
//    }
//
//    @PostMapping("/postUploadVideoData")
//    public ResponseResult postUploadVideoData(@RequestPart("dataFile") MultipartFile dataFile){
//        UploadVideoVo uploadVideoVo = new UploadVideoVo();
//        long userId = JwtUtil.getUserId();
//
//        String videoDataUrl = "";
//
//        String uploadVideoDataDir = "D:/uploads/videos/data/";
//        uploadVideoFile(dataFile,uploadVideoDataDir);
//        videoDataUrl = uploadVideoFile(dataFile,uploadVideoDataDir);
//        uploadVideoVo.setDataUrl(videoDataUrl);
//        uploadVideoVo.setVideoName(dataFile.getOriginalFilename());
//        uploadVideoVo.setVideoName(dataFile.getOriginalFilename());
//
//        uploadVideoVo.setUserId(userId);
//
//        Video video = new Video(uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
//                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
//                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);
//
//        videoService.insertVideo(video);
//        return new ResponseResult(200, "上传视频文件成功");
//    }
//
//    @PostMapping("/postUploadVideoCover")
//    public ResponseResult postUploadVideoCover(@RequestPart("coverFile") MultipartFile coverFile){
//        long userId = JwtUtil.getUserId();
//        UploadVideoVo uploadVideoVo = new UploadVideoVo();
//        String videoCoverUrl = "";
//
//        //Todo 最好放在配置文件
//        // 定义保存路径
//        String uploadVideoCoverDir = "D:/uploads/videos/cover/";
//        uploadVideoFile(coverFile,uploadVideoCoverDir);
//        videoCoverUrl = uploadVideoFile(coverFile,uploadVideoCoverDir);
//        uploadVideoVo.setCoverUrl(videoCoverUrl);
//
//
//        uploadVideoVo.setUserId(userId);
//
//        Video video = new Video(uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
//                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
//                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);
//
//        videoService.insertVideo(video);
//
//        return new ResponseResult(200,"上传视频封面成功");
//    }

    @Transactional
    @PostMapping("/postUploadVideoCommodity")
    public ResponseResult postUploadVideoCommodity(@RequestBody UploadVideoVO uploadVideoVo){
        long userId = JwtUtil.getUserId();
        VideoPO videoPO = videoService.findByVideoId(uploadVideoVo.getId());

        //将商品安排到video推荐商品里
        for (Long cId : uploadVideoVo.getCommodityIdList()) {
            VideoCommodityPO videoCommodityPO = new VideoCommodityPO(userId, uploadVideoVo.getId(), cId,
                    videoPO.getVideoStatus());
            videoCommodityService.insertVideoCommodity(videoCommodityPO);
        }

        return new ResponseResult(200,"操作成功");
    }

    @Transactional
    @PostMapping ("/postDeleteVideo")
    public ResponseResult deleteVideo(long videoId){
        videoService.deleteVideo(videoId);
        return new ResponseResult(200, "操作成功");
    }
    @Transactional
    @PutMapping("/putUpdateVideoMsg")
    public ResponseResult putUpdateVideoMsg(@RequestBody UploadVideoVO uploadVideoVo) {
        VideoPO videoPO = new VideoPO(uploadVideoVo.getId(),uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(),
                uploadVideoVo.getVideoDescription(), uploadVideoVo.getCoverUrl());
        videoService.updateVideoMsg(videoPO);
        return new ResponseResult(200,"操作成功");
    }
    @Transactional
    @PutMapping("/putUpdateVideoCommodityMsg")
    public ResponseResult putUpdateVideoCommodityMsg(@RequestBody UploadVideoVO uploadVideoVo){

        for (Long cId:uploadVideoVo.getCommodityIdList()) {
            VideoCommodityPO videoCommodityPO = new VideoCommodityPO(uploadVideoVo.getId(),cId);
            videoCommodityService.updateVideoCommodityMsg(videoCommodityPO);
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
    @Transactional
    @PostMapping("/insertTestVideo")
    public ResponseResult insertTestVideo(UploadVideoVO uploadVideoVo){
        VideoPO videoPO = new VideoPO(uploadVideoVo.getUserId(), uploadVideoVo.getVideoName(),
                uploadVideoVo.getVideoTitle(), uploadVideoVo.getVideoType(), uploadVideoVo.getVideoDescription(),
                uploadVideoVo.getCoverUrl(), uploadVideoVo.getDataUrl(),1);
        videoService.insertVideo(videoPO);
        return new ResponseResult(200,"上传成功");
    }


}
