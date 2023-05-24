package com.feidian.controller;

import com.feidian.domain.*;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.*;
import com.feidian.util.JwtUtil;
import com.feidian.vo.UserHomepageVo;
import com.feidian.vo.VideosVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@RestController
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

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

//    public ResponseResult releaseCommodity(CommodityVo commodityVo){
//        commodityService.releaseCommodity(commodityVo);
//        return new ResponseResult(200,"发布成功");
//    }

    public ResponseResult writePersonalDescription(@RequestBody UserHomepageVo userHomepageVo){
        userService.updateUserDescription(userHomepageVo.getUserDescription());
        return new ResponseResult(200,"发布成功");
    }

    @GetMapping("/perinfo")
    public ResponseResult getHomePage(){
        long userId = JwtUtil.getUserId();

        User user = userService.findById(userId);
        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);
        List<Order> orderList = orderService.findByUserId(userId);
        List<Cart> cartList = cartService. findByUserId(userId);

        UserHomepageVo userHomepageVo = new UserHomepageVo(userId, user.getUsername(),
                user.getUserDescription(), user.getPhone(), user.getHeadUrl(),
                user.getEmailAddress(), videoList, commodityList, orderList, cartList);
        return  new ResponseResult(200,"操作成功",userHomepageVo);
    }

    @GetMapping("/pervideo")
    public ResponseResult getVideos(){
        long userId = JwtUtil.getUserId();

        List<Video> videoList = videoService.findByUserId(userId);
        List<Commodity> commodityList = commodityService.findByUserId(userId);

        VideosVo videosVo = new VideosVo(videoList, commodityList);

        return new ResponseResult(200,"操作成功",videosVo);
    }


    @RequestMapping("/upload")
    public String upload(MultipartFile uploadFile) throws IOException {
        //文件存储 把上传上来的文件存储下来
        uploadFile.transferTo(new File("test.sql"));
        return "/success.jsp";
    }
}
