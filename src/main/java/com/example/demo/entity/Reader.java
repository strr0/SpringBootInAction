package com.example.demo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Reader implements UserDetails {    //实现UserDetails 可以代表SpringSecurity的用户
    @Id
    private String username;
    private String fullname;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String getUsername() {
        return username;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getFullname() {
        return fullname;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_READER"));    //授予READER权限
    }
    @Override
    public boolean isAccountNonExpired() {    //不过期
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {    //不加锁
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {    //不过期
        return true;
    }
    @Override
    public boolean isEnabled() {    //不禁用
        return true;
    }
}
