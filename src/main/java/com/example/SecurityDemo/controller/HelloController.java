package com.example.SecurityDemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangkun
 * @Date: 2020/3/27
 */
@RestController
@Api("hello controller")
public class HelloController {

    @GetMapping("/hello")
    @ApiOperation(value = "hello")
    @PreAuthorize("@mySecurityService.allow(authentication,@functionsDefine.FUNCTION_1)")
    public String hello(){
        return "hello";
    }

    @GetMapping("/test")
    @ApiOperation(value = "test")
    @PreAuthorize("@mySecurityService.allow(authentication,@functionsDefine.FUNCTION_2)")
    public String test(){
        return "test";
    }

}
