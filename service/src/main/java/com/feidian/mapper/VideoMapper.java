package com.feidian.mapper;

import com.feidian.domain.Video;
import com.feidian.vo.VideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {

    void deleteVideo();

    void insertVideo(VideoVo videoVo);

    void findByVideoName();

    Video findByVideoId(Integer id);

    List<Video> findByUserId(long userId);
}
