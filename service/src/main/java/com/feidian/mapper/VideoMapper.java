package com.feidian.mapper;

import com.feidian.domain.Video;
import com.feidian.vo.DisplayVideoVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface VideoMapper {

    void deleteVideo(long videoId);

    void insertVideo(Video video);

    void findByVideoName();

    Video findByVideoId(long id);

    List<Video> findByUserId(long userId);
}
