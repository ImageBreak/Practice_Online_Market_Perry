package net.perry.online_class.mapper;

import java.util.List;

import net.perry.online_class.domain.Video;

public interface VideoMapper {
    
    /**
     * 查询视频列表
     * @return
     */
    List<Video> listVideo();
}
