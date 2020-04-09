package com.example.SecurityDemo.service;

import com.example.SecurityDemo.mapper.UserMapper;
import com.example.SecurityDemo.pojo.MyUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangkun
 * @Date: 2020/4/1
 */
@Slf4j
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser myUser = userMapper.getUserByUsername(s);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(myUser != null){
            myUser.getRoleList().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
        }
        UserDetails user = User.builder()
                .username(myUser.getUsername())
                .password(myUser.getPassword())
                .authorities(authorities)
                .build();
        log.debug("username:{},password:{}",user.getUsername(),user.getPassword());
        return user;
    }
}
