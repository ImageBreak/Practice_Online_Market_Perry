package net.perry.online_class.mapper;

import org.apache.ibatis.annotations.Param;

import net.perry.online_class.domain.User;

public interface UserMapper {
    
    int save(User user);

    User findByPhone(@Param("phone") String phone);
}
