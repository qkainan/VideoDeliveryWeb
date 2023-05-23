package com.feidian.service.impl;

import com.feidian.domain.Video;
import com.feidian.mapper.VideoMapper;
import com.feidian.service.VideoService;
import com.feidian.vo.VideoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public void uploadVideo(VideoVo videoVo) {
        videoMapper.insertVideo(videoVo);
    }

    @Override
    public Integer[] homeRecommend() {
        //创建一个新的数组
        Integer[] arr = new Integer[5];
        //把随机数存入数组当中
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            //每循环一次，就会生成一个随机数
            Integer num = r.nextInt(100 + 1);
            //把生成的随机数存入数组当中
            arr[i] = num;
        }

        return arr;
    }

    @Override
    public Video findByVideoId(Integer id) {
        return videoMapper.findByVideoId(id);
    }

    @Override
    public List<Video> findByUserId(long userId) {
        return videoMapper.findByUserId(userId);
    }


}

