package com.security3.Oauth.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security3.Oauth.Mapper.UserMapper;
import com.security3.Oauth.Domain.Users;
import com.security3.Oauth.Domain.Role;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        Role role=null;
        try{
            role=userMapper.getUserDetails(username); 
            Users userDetail=new Users(role);
            return  userDetail;
        }catch (Exception e)
        {
            e.printStackTrace();
            throw new UsernameNotFoundException("username" + username +"was not found in the database");
        }

    }
}
