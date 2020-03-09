package com.xks.client.mapper;

import com.xks.client.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{userName}")
    User findByUserName(String userName);
}
