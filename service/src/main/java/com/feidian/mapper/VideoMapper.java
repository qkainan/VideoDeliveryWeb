package com.feidian.mapper;

import com.feidian.vo.VideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface VideoMapper {
    void updateVideo();

    void deleteVideo();

    void insertVideo(VideoVo videoVo);

    void findByVideoName();
}
