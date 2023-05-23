package com.feidian.controller;

import com.feidian.domain.Commodity;
import com.feidian.responseResult.ResponseResult;
import com.feidian.service.CommodityService;
import com.feidian.util.JwtUtil;
import com.feidian.vo.CommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
