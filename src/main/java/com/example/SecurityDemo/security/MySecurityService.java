package com.example.SecurityDemo.security;

import com.example.SecurityDemo.mapper.UserMapper;
import com.example.SecurityDemo.pojo.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangkun
 * @Date: 2020/4/3
 */
@Slf4j
@Component
public class MySecurityService {

    @Autowired
    private UserMapper userMapper;

    public boolean hasPermission(Authentication authentication) {
        long count = authentication.getAuthorities()
                .stream()
                .filter(e->{
                    log.info(((GrantedAuthority) e).toString());
                    return ((GrantedAuthority) e).toString().equals("ROLE_ADMIN");
                })
                .count();
        return count > 0;
    }

    public boolean allow(Authentication authentication,int functionId){
        log.info("functionId : {}",functionId);
        List<Integer> allowFunctions = new ArrayList<>();
        authentication.getAuthorities().forEach(e->{
            List<Function> functionList = userMapper.getFunctionsByRoleName(e.toString());
            functionList.forEach(f->{
                allowFunctions.add(f.getFunctionId());
            });
        });
        return allowFunctions.contains(functionId);
    }

}
