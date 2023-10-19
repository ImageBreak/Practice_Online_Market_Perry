package net.perry.online_class.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.perry.online_class.mapper.VideoMapper;
import net.perry.online_class.mapper.VideoOrderMapper;
import net.perry.online_class.model.entity.Video;
import net.perry.online_class.model.entity.VideoOrder;
import net.perry.online_class.service.VideoOrderService;

@Service
public class VideoOrderServiceImpl implements VideoOrderService{
    
    @Autowired
    private VideoOrderMapper videoOrderMapper;

    @Autowired
    private VideoMapper videoMapper;

    /**
     * 下单操作
     * 未来版本：优惠券抵扣，风控用户检查，生产订单基础信息，生成支付信息
     * @param userId
     * @param videoId
     * @return
     */
    @Override
    public int save(int userId, int videoId){

        //判断是否已经购买
        VideoOrder videoOrder = videoOrderMapper.findByUserIdAndVideoIdAndState(userId, videoId, 1);
        if(videoOrder != null){
            return 0;
        }

        Video video = videoMapper.findById(videoId);

        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        //默认成功
        newVideoOrder.setState(1);
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);
        return rows;
    }
}
