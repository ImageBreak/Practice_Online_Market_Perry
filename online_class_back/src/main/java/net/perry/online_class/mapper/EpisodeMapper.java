package net.perry.online_class.mapper;

import org.apache.ibatis.annotations.Param;

import net.perry.online_class.model.entity.Episode;

public interface EpisodeMapper {
    
    /**
     * 根据视频ID去找到第一集
     * @param videoId
     * @return
     */
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
