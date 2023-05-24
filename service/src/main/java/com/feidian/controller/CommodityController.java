package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.domain.Video;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.CommodityVo;
import com.feidian.vo.UploadCommodityVo;
import com.feidian.vo.UploadVideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/goods")
    public ResponseResult findByCommodityId(long id){

        Commodity commodity = commodityService.findByCommodityId(id);

        CommodityVo commodityVo = new CommodityVo(commodity.getId(), commodity.getCommodityName(),
                commodity.getCommodityType(), commodity.getPrice(), commodity.getCommodityAddress(),
                commodity.getCommodityDescription(), commodity.getCoverUrl());

        return new ResponseResult(200,"操作成功", commodityVo);

    }

    @GetMapping("/pergoods")
    public ResponseResult findByUserId(long id){
        long userId = JwtUtil.getUserId();

        List list = commodityService.findByUserId(userId);

        return new ResponseResult(200,"操作成功",list);
    }

    @PostMapping("/updateCommodityMsg")
    public ResponseResult updateCommodityMsg(@RequestBody CommodityVo commodityVo, @RequestPart(required = false) MultipartFile file){
        Commodity commodity = new Commodity();
        commodityService.insertCommodity(commodity);
        return new ResponseResult(200,"操作成功");
    }

    @PostMapping("/uploadCommodity")
    public ResponseResult uploadVideo(@RequestBody UploadCommodityVo uploadCommodityVo,
                                      @RequestPart("coverFile") MultipartFile coverFile){

        long userId = JwtUtil.getUserId();

        String videoDataUrl = "";
        String videoCoverUrl = "";

        // 定义保存路径
        String uploadVideoCoverDir ="C:/uploads/videos/cover/";

        uploadCommodityFile(coverFile,uploadVideoCoverDir);

        videoCoverUrl = uploadCommodityFile(coverFile,uploadVideoCoverDir);

        uploadCommodityVo.setUserId(userId);

        uploadCommodityVo.setCoverUrl(videoCoverUrl);


        Commodity commodity = new Commodity(uploadCommodityVo.getId(), uploadCommodityVo.getUserId(),
                uploadCommodityVo.getCommodityName(), uploadCommodityVo.getCommodityType(),
                uploadCommodityVo.getPrice(), uploadCommodityVo.getCommodityDescription(),
                uploadCommodityVo.getCommodityAddress(), uploadCommodityVo.getCoverUrl());

        commodityService.insertCommodity(commodity);

        return new ResponseResult(200,"操作成功");
    }


    public String uploadCommodityFile(MultipartFile file,String uploadDir) {

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
