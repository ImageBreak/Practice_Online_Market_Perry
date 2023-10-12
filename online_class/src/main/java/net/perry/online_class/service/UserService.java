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

    /**
     * 校验用户登录
     * @param phone
     * @param pwd
     * @return
     */
    String findByPhoneAndPwd(String phone, String pwd);
    
}
