package com.chen.springbootdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chen
 * @Date: 2018/12/11 17:16
 * @Description:
 */
@RestController
@RequestMapping("/hello")
//@Api(value = "HelloAction", tags = {"演示接口:HelloAction"}, description = "用于演示的action")
@Api(value = "HelloAction", description = "用于演示的action")
public class HelloAction {


    //@ApiOperation(value = "向指定用户,say hello", tags = {"用于向用户说你好"}, notes = "注意问题")
    @ApiOperation(value = "向指定用户,say hello", notes = "注意问题")
    @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String")
    @GetMapping(value = "/say")
    public String say(String name) {

        return "hello , " + name;
    }



}
