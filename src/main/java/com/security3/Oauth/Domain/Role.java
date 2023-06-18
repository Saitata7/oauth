package com.security3.Oauth.Domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;


public class Role{
	private String username;
    private String password;
    private Collection<GrantedAuthority> listofgrantedAuthorities=new ArrayList<>();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GrantedAuthority> getListofgrantedAuthorities() {
        return listofgrantedAuthorities;
    }

    public void setListofgrantedAuthorities(Collection<GrantedAuthority> listofgrantedAuthorities) {
        this.listofgrantedAuthorities = listofgrantedAuthorities;
    }

}
