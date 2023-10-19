package net.perry.online_class.service;

import org.springframework.stereotype.Service;

@Service
public interface VideoOrderService {
    
    int save(int userId, int videoId);
}
