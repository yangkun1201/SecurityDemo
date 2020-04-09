package com.example.SecurityDemo.pojo;

import lombok.Data;

import java.util.List;

/**
 * @Author: yangkun
 * @Date: 2020/3/31
 */
@Data
public class MyUser {
    int id;
    String username;
    String password;
    List<Role> roleList;
}
