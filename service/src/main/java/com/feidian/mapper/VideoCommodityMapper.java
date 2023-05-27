package com.feidian.mapper;

import com.feidian.domain.VideoCommodity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoCommodityMapper {
    void insertVideoCommodity(VideoCommodity videoCommodity);

    List<VideoCommodity> findByVideoId(long videoId);

    void updateVideoCommodityMsg(VideoCommodity videoCommodity);
}
