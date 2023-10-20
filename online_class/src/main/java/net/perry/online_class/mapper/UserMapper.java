package net.perry.online_class.mapper;

import org.apache.ibatis.annotations.Param;

import net.perry.online_class.model.entity.User;

public interface UserMapper {
    
    /**
     * 注册新用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     * 根据电话号码查找用户
     * @param phone
     * @return
     */
    User findByPhone(@Param("phone") String phone);

    /**
     * 验证电话号码和密码是否匹配
     * @param phone
     * @param pwd
     * @return
     */
    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    User findByUserId(@Param("user_id") Integer userId);
}
