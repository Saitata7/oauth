package com.security3.Oauth.Domain;

import org.springframework.security.core.userdetails.User;

public class Users extends User{
	
    private static final long serialVersioUId=1L;

    public Users(Role user) {
        super(
        		user.getUsername(),
                user.getPassword(),
                user.getListofgrantedAuthorities()
        );
    }

}
