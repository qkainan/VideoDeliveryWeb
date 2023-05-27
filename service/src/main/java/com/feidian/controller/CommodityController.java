package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.CommodityImage;
import com.feidian.domain.Video;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityImageService;
import com.feidian.service.CommodityService;
import com.feidian.util.JwtUtil;
import com.feidian.util.fileUploadUtil;
import com.feidian.vo.CommodityVo;
import com.feidian.vo.DataAndCoverResource;
import com.feidian.vo.ImageAndCoverResource;
import com.feidian.vo.UploadCommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityImageService commodityImageService;

    @PostMapping("/getCommodity")
    public ResponseResult findByCommodityId(long commodityId) throws IOException {

        Commodity commodity = commodityService.findByCommodityId(commodityId);

        CommodityVo commodityVo = new CommodityVo(commodity.getId(), commodity.getCommodityName(),
                commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityAddress(),
                commodity.getCommodityDescription(), commodity.getCoverUrl());

        List<InputStreamResource> imageUrlList = new ArrayList<>();
        for (CommodityImage ci:commodityImageService.findByCommodityId(commodityVo.getId())) {
            imageUrlList.add(fileUploadUtil.getCommodityImage(ci.getImageUrl()));
        }
        ImageAndCoverResource imageAndCoverResource = new ImageAndCoverResource(
                fileUploadUtil.getCommodityCover(commodityVo.getCoverUrl()),imageUrlList );

        Map<CommodityVo,ImageAndCoverResource> map = new HashMap<>();
        map.put(commodityVo, imageAndCoverResource);
        return new ResponseResult(200,"操作成功", map);

    }

    @GetMapping("/getDisplayCommodity")
    public ResponseResult getDisplayCommodity(long commodityId) throws IOException {
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

        commodityService.insertCommodity(commodity.getId(), commodity.getUserId(), commodity.getCommodityName(),
                commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityDescription(),
                commodity.getCommodityAddress(), commodity.getCoverUrl());

        return new ResponseResult(200,"更改成功");
    }

    @PostMapping(value = "/postUploadCommodity", consumes = "multipart/form-data")
    public ResponseResult uploadCommodity(@RequestPart(name = "uploadCommodityVo") UploadCommodityVo uploadCommodityVo,
                                          @RequestPart(name = "coverFile") MultipartFile coverFile,
                                          @RequestPart(name = "imageFile") MultipartFile[] imageFile) {

        long userId = JwtUtil.getUserId();

        String commodityCoverUrl = "";
        String uploadCommodityCoverDir = "D:/uploads/commodities/cover/";
        uploadCommodityFile(coverFile, uploadCommodityCoverDir);
        commodityCoverUrl = uploadCommodityFile(coverFile, uploadCommodityCoverDir);
        uploadCommodityVo.setCoverUrl(commodityCoverUrl);


        uploadCommodityVo.setUserId(userId);

        Commodity commodity = new Commodity(uploadCommodityVo.getId(), uploadCommodityVo.getUserId(),
                uploadCommodityVo.getCommodityName(), uploadCommodityVo.getCommodityType(),
                uploadCommodityVo.getPrice(), uploadCommodityVo.getCommodityDescription(),
                uploadCommodityVo.getCommodityAddress(), uploadCommodityVo.getCoverUrl());


        String commodityImageUrl = "";
        String uploadCommodityImageDir = "D:/uploads/commodities/image/";
        for (MultipartFile multipartFile :imageFile) {
            uploadCommodityFile(multipartFile, uploadCommodityImageDir);
            commodityImageUrl = uploadCommodityFile(multipartFile, uploadCommodityImageDir);
            commodityImageService.insertCommodityImage(commodity.getId(), commodityImageUrl, 1);
        }

        commodityService.insertCommodity(commodity.getId(), commodity.getUserId(),
                commodity.getCommodityName(), commodity.getCommodityType(), commodity.getPrice(),
                commodity.getCommodityDescription(), commodity.getCommodityAddress(), commodity.getCoverUrl());

        return new ResponseResult(200, "操作成功");
    }

    @PostMapping("/postDeleteCommodity")
    public ResponseResult deleteCommodity(long commodityId){
        commodityService.deleteCommodity(commodityId);
        return new ResponseResult(200, "删除成功");
    }

    public String uploadCommodityFile(@RequestPart("file") MultipartFile file, String uploadDir) {

        // 处理文件上传逻辑
        // 进行视频文件的保存、处理等操作
        // 返回相应的结果

        if (file.isEmpty()) {
            return "0";
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
