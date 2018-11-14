package com.chen.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chen on 2018/10/24 16:00
 */
@Controller
@RequestMapping(value = "/main")
public class MainController {
    /**
     * 功能描述:记录日志
     */
    public static Logger log =LoggerFactory.getLogger(MainController.class);
    /**
     * 功能描述:进入首页
     * @auther: chen
     * @date: 2018/10/31 16:29
     */
    @RequestMapping(value = "/main")
    public ModelAndView showmain(ModelAndView mv){
        mv.setViewName("main");
        return mv;
    }
    /**
     * 功能描述:
     * @param:
     * @return:
     * @auther: chen
     * @date: 2018/10/31 17:18
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public String getPara(HttpServletRequest request){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        return name+password;
    }


}
