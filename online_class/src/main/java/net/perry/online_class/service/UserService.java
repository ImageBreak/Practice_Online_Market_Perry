package net.perry.online_class.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);
    
}
