package com.feidian.service.impl;

import com.feidian.domain.VideoCommodity;
import com.feidian.mapper.VideoCommodityMapper;
import com.feidian.service.VideoCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommodityServiceImpl implements VideoCommodityService {

    @Autowired
    private VideoCommodityMapper videoCommodityMapper;

    @Override
    public void insertVideoCommodity(VideoCommodity videoCommodity) {
        videoCommodityMapper.insertVideoCommodity(videoCommodity);
    }

    @Override
    public List<VideoCommodity> findByVideoId(long videoId) {
        return videoCommodityMapper.findByVideoId(videoId);
    }

    @Override
    public void updateVideoCommodityMsg(VideoCommodity videoCommodity) {
        videoCommodityMapper.updateVideoCommodityMsg(videoCommodity);
    }
}
