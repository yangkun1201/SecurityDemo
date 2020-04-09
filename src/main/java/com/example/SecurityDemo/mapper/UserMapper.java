package com.example.SecurityDemo.mapper;

import com.example.SecurityDemo.pojo.Function;
import com.example.SecurityDemo.pojo.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yangkun
 * @Date: 2020/3/31
 */
@Repository
@Mapper
public interface UserMapper {

    MyUser getUserByUsername(@Param("username") String username);

    List<Function> getFunctionsByRoleName(@Param("roleName") String roleName);

}
