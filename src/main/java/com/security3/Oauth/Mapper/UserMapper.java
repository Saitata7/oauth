package com.security3.Oauth.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.security3.Oauth.Domain.Role;

@Mapper
public interface UserMapper {
    @Select(" select * from users where username=#{username}")
    public Role getUserDetails(String username);

}
