package com.feidian.service;

import com.feidian.domain.VideoCommodity;

import java.util.List;

public interface VideoCommodityService {
    void insertVideoCommodity(VideoCommodity videoCommodity);

    List<VideoCommodity> findByVideoId(long videoId);

    void updateVideoCommodityMsg(VideoCommodity videoCommodity);
}
