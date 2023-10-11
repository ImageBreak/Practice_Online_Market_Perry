package net.perry.online_class.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.perry.online_class.domain.Video;
import net.perry.online_class.domain.VideoBanner;

public interface VideoMapper {
    
    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情，章，集信息
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);
}
