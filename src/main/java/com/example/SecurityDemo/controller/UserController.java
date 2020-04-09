package com.example.SecurityDemo.controller;

import com.example.SecurityDemo.mapper.UserMapper;
import com.example.SecurityDemo.pojo.MyUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yangkun
 * @Date: 2020/3/31
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("login")
    public Map<String,Object> login(){
        Map<String,Object> result = new HashMap<>();
        result.put("msg","登录成功");
        return result;
    }

    @GetMapping("/getUserByUsername")
    public PageInfo getUserByUsername(@RequestParam String username){
        PageHelper.startPage(1,10);
        MyUser data = userMapper.getUserByUsername(username);
        List<MyUser> list = Arrays.asList(data);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
