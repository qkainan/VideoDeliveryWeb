package com.feidian.controller;

import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.service.UserService;
import com.feidian.service.VideoService;
import com.feidian.vo.CommodityVo;
import com.feidian.vo.UserHomepageVo;
import com.feidian.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Controller
@CrossOrigin
public class UserHomepageController {

    //Todo 上传视频（视频名称、视频封面、编写视频简介、获取视频发布时间） 视频资源路径
    // 发布商品（商品名称、价格、商品简介、商品封面、获取商品发布时间）
    // 编写个人签名

    @Autowired
    private UserService userService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private VideoService videoService;

    public ResponseResult uploadVideo(VideoVo videoVo){
        videoService.uploadVideo(videoVo);
        return new ResponseResult(200,"上传成功");
    }

    public ResponseResult releaseCommodity(CommodityVo commodityVo){
        commodityService.releaseCommodity(commodityVo);
        return new ResponseResult(200,"发布成功");
    }

    public ResponseResult writePersonalDescription(@RequestBody UserHomepageVo userHomepageVo){
        userService.updateUserDescription(userHomepageVo.getUserDescription());
        return new ResponseResult(200,"发布成功");
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile) throws IOException {
        //文件存储 把上传上来的文件存储下来
        uploadFile.transferTo(new File("test.sql"));
        return "/success.jsp";
    }
}
