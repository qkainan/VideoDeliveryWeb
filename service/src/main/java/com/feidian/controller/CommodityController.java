package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.CommodityImage;
import com.feidian.domain.Video;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityImageService;
import com.feidian.service.CommodityService;
import com.feidian.util.JwtUtil;
import com.feidian.util.fileUploadUtil;
import com.feidian.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityImageService commodityImageService;

//    @PostMapping("/getCommodity")
//    public ResponseResult findByCommodityId(Long commodityId) throws IOException {
//
//        Commodity commodity = commodityService.findByCommodityId(commodityId);
//
//        CommodityVo commodityVo = new CommodityVo(commodity.getId(), commodity.getCommodityName(),
//                commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityAddress(),
//                commodity.getCommodityDescription(), commodity.getCoverUrl());
//
//        List<InputStreamResource> imageUrlList = new ArrayList<>();
//        for (CommodityImage ci:commodityImageService.findByCommodityId(commodityVo.getId())) {
//            imageUrlList.add(fileUploadUtil.getCommodityImage(ci.getImageUrl()));
//        }
//        ImageAndCoverResource imageAndCoverResource = new ImageAndCoverResource(
//                fileUploadUtil.getCommodityCover(commodityVo.getCoverUrl()),imageUrlList );
//
//        Map<CommodityVo,ImageAndCoverResource> map = new HashMap<>();
//        map.put(commodityVo, imageAndCoverResource);
//        return new ResponseResult(200,"操作成功", map);
//
//    }

    @PostMapping("/getCommodity")
    public ResponseResult findByCommodityId(long commodityId) throws IOException, URISyntaxException {
        Commodity commodity = commodityService.findByCommodityId(commodityId);

        if (commodity != null) {
            CommodityVo commodityVo = new CommodityVo(commodity.getId(), commodity.getCommodityName(),
                    commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityAddress(),
                    commodity.getCommodityDescription(), commodity.getCoverUrl());

            List<InputStreamResource> imageUrlList = new ArrayList<>();
            List<CommodityImage> commodityImageList = commodityImageService.findByCommodityId(commodityVo.getId());

            if (commodityImageList != null) {
                for (CommodityImage ci : commodityImageList) {
                    imageUrlList.add(fileUploadUtil.getCommodityImage(ci.getImageUrl()));
                }
            }

            ImageAndCoverResource imageAndCoverResource = new ImageAndCoverResource(
                    fileUploadUtil.getCommodityCover(commodityVo.getCoverUrl()), imageUrlList);

            Map<CommodityVo, ImageAndCoverResource> map = new HashMap<>();
            map.put(commodityVo, imageAndCoverResource);
            return new ResponseResult(200, "操作成功", map);
        } else {
            return new ResponseResult(404, "未找到商品", null);
        }
    }


    @GetMapping("/getDisplayCommodity")
    public ResponseResult getDisplayCommodity(Long commodityId) throws IOException, URISyntaxException {
        HashMap<Long, ImageAndCoverResource> map = new HashMap<>();
        Commodity commodity = commodityService.findByCommodityId(commodityId);
        List<CommodityImage> commodityImageList = commodityImageService.findByCommodityId(commodityId);
        List<InputStreamResource> imageResourceList = new ArrayList<>();

        for (CommodityImage commodityImage : commodityImageList) {
            imageResourceList.add(fileUploadUtil.getCommodityImage(commodityImage.getImageUrl()));
        }
        ImageAndCoverResource imageAndCoverResource =
                new ImageAndCoverResource(fileUploadUtil.getCommodityCover(commodity.getCoverUrl()),
                        imageResourceList);
        map.put(commodity.getId(), imageAndCoverResource);

        return new ResponseResult(200, "操作成功", map);
    }

    @PutMapping("/putUpdateCommodityMsg")
    public ResponseResult updateCommodityMsg(@RequestBody CommodityVo commodityVo){

        Commodity commodity = new Commodity(commodityVo.getId(), JwtUtil.getUserId(), commodityVo.getCommodityName(),
                commodityVo.getCommodityType(), commodityVo.getPrice(), commodityVo.getCommodityDescription(),
                commodityVo.getCommodityAddress(), commodityVo.getCoverUrl());

        commodityService.insertCommodity( commodity.getUserId(), commodity.getCommodityName(),
                commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityDescription(),
                commodity.getCommodityAddress(), commodity.getCoverUrl());

        return new ResponseResult(200,"更改成功");
    }


    @PostMapping("/postUploadCommodityVo")
    public ResponseResult postUploadCommodityVo( @RequestPart("uploadCommodityVo") UploadCommodityVo uploadCommodityVo){
        commodityService.insertCommodity(uploadCommodityVo.getUserId(),uploadCommodityVo.getCommodityName(),
                uploadCommodityVo.getCommodityType(), uploadCommodityVo.getPrice(),uploadCommodityVo.getCommodityDescription()
                ,uploadCommodityVo.getCommodityAddress(), uploadCommodityVo.getCoverUrl());
        return new ResponseResult(200,"上传商品信息成功");
    }
    @PostMapping("/uploadCover")
    public ResponseResult uploadCover(@RequestPart("file")MultipartFile file){
        saveCommodityFile(file,"D:/uploads/commodities/cover/");
        return new ResponseResult(200, "上传封面成功");
    }
    @PostMapping("/uploadImage")
    public ResponseResult uploadImage(@RequestPart("file")MultipartFile[] files){
        for (MultipartFile f : files){
            saveCommodityFile(f,  "D:/uploads/commodities/image/");
        }
        return new ResponseResult(200, "上传商品图片成功");
    }

    @PostMapping("/postDeleteCommodity")
    public ResponseResult deleteCommodity(long commodityId){
        commodityService.deleteCommodity(commodityId);
        return new ResponseResult(200, "删除成功");
    }


    public String saveCommodityFile(MultipartFile file, String uploadDir) {
        // 处理文件上传逻辑
        // 进行视频文件的保存、处理等操作
        // 返回相应的结果

        if (file.isEmpty()) {
            return "未选择文件";
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

            return filePath;
        } catch (IOException e) {
            return "上传失败" + e.getMessage();
        }
    }


   @PostMapping(value = "/postUploadCommodity", consumes = "multipart/form-data")
    public ResponseResult uploadCommodity(@RequestPart(name = "uploadCommodityVo") UploadCommodityVo uploadCommodityVo,
                                          @RequestPart(name = "coverFile") MultipartFile coverFile,
                                          @RequestPart(name = "imageFile") MultipartFile[] imageFile) {

        long userId = JwtUtil.getUserId();

        String commodityCoverUrl = "";
        String uploadCommodityCoverDir = "D:/uploads/commodities/cover/";
        saveCommodityFile(coverFile, uploadCommodityCoverDir);
        commodityCoverUrl = saveCommodityFile(coverFile, uploadCommodityCoverDir);
        uploadCommodityVo.setCoverUrl(commodityCoverUrl);


        uploadCommodityVo.setUserId(userId);

        Commodity commodity = new Commodity(uploadCommodityVo.getId(), uploadCommodityVo.getUserId(),
                uploadCommodityVo.getCommodityName(), uploadCommodityVo.getCommodityType(),
                uploadCommodityVo.getPrice(), uploadCommodityVo.getCommodityDescription(),
                uploadCommodityVo.getCommodityAddress(), uploadCommodityVo.getCoverUrl());


        String commodityImageUrl = "";
        String uploadCommodityImageDir = "D:/uploads/commodities/image/";
        for (MultipartFile multipartFile :imageFile) {
            saveCommodityFile(multipartFile, uploadCommodityImageDir);
            commodityImageUrl = saveCommodityFile(multipartFile, uploadCommodityImageDir);
            commodityImageService.insertCommodityImage(commodity.getId(), commodityImageUrl, 1);
        }

        commodityService.insertCommodity( commodity.getUserId(),
                commodity.getCommodityName(), commodity.getCommodityType(), commodity.getPrice(),
                commodity.getCommodityDescription(), commodity.getCommodityAddress(), commodity.getCoverUrl());

        return new ResponseResult(200, "操作成功");
    }

//    @PostMapping("/postUploadCommodityData")
//    public ResponseResult postUploadCommodityData(@RequestPart("dataFile") MultipartFile dataFile){
//        UploadVideoVo uploadVideoVo = new UploadVideoVo();
//        long userId = JwtUtil.getUserId();
//
//        String videoDataUrl = "";
//
//        String uploadVideoDataDir = "http://117.50.163.249:8088/home/www/uploads/videos/data/";
//        saveCommodityFile(dataFile,uploadVideoDataDir);
//        videoDataUrl = saveCommodityFile(dataFile,uploadVideoDataDir);
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

//    @PostMapping("/postUploadCommodityCover")
//    public ResponseResult postUploadCommodityCover(@RequestPart("coverFile") MultipartFile coverFile){
//        long userId = JwtUtil.getUserId();
//        UploadVideoVo uploadVideoVo = new UploadVideoVo();
//        String videoCoverUrl = "";
//
//        String uploadVideoCoverDir = "http://117.50.163.249:8088/home/www/uploads/videos/cover/";
//        saveCommodityFile(coverFile,uploadVideoCoverDir);
//        videoCoverUrl = saveCommodityFile(coverFile,uploadVideoCoverDir);
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


}
