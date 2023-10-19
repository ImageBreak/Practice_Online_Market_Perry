package net.perry.online_class.mapper;

import org.apache.ibatis.annotations.Param;

import net.perry.online_class.model.entity.VideoOrder;

public interface VideoOrderMapper {
    
    /**
     * 查询用户是否购买过此商品
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder findByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    /**
     * 下单
     * @param videoOrder
     * @return
     */
    int saveOrder(VideoOrder videoOrder);
}
