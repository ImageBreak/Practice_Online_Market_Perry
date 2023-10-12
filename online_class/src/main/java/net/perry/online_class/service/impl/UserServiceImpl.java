package net.perry.online_class.service.impl;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.perry.online_class.mapper.UserMapper;
import net.perry.online_class.model.entity.User;
import net.perry.online_class.service.UserService;
import net.perry.online_class.utils.CommonUtils;
import net.perry.online_class.utils.JWTUtils;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(Map<String, String> userInfo) {
        
        User user = parseToUser(userInfo);
        if(user != null){
            return userMapper.save(user);
        }else{
            return -1;
        }
    }

    /**
     * 解析user对象
     * @param userInfo
     * @return
     */
    private User parseToUser(Map<String, String> userInfo) {

        if(userInfo.containsKey("phone") && userInfo.containsKey("pwd") && userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            user.setPhone(userInfo.get("phone"));
            String pwd = userInfo.get("pwd");
            //MD5加密
            user.setPwd(CommonUtils.MD5(pwd));
            return user;
        }else{
            return null;
        }        
    }

    /**
     * 存放于CDN的随机头像
     */
    private static final String [] headImg = {
        "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
        "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
        "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
        "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
        "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };
    
    /**
     * 获取随机头像存放地址
     * @return
     */
    private String getRandomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }

    /**
     * 校验用户登录的实现
     */
    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));

        if (user == null){
            return null;
        }else{
            String token = JWTUtils.genJsonWebToken(user);
            return token;
        }
    }
}
