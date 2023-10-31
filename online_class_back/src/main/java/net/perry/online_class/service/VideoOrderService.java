package net.perry.online_class.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.perry.online_class.model.entity.VideoOrder;

@Service
public interface VideoOrderService {
    
    int save(int userId, int videoId);

    List<VideoOrder> listOrderByUserId(Integer userId);
}
