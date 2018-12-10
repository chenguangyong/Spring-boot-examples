package com.chen.springbootdemo.controller;

import com.chen.springbootdemo.service.UserService;
import com.winter.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/freemarker")
public class LoginController {
    @Autowired
    private UserService userService;


    private static Logger log = LoggerFactory.getLogger(LoginController.class);
   
    /**
     * 功能描述:跳转freemarker页面
     * @param: [mv]
     * @return: org.springframework.web.servlet.ModelAndView
     * @auther: chen
     * @date: 2018/10/24 16:17
     */
    @RequestMapping(value = "/login")
    public ModelAndView toDemo(ModelAndView mv) {
        log.info("---->跳转freemarker页面");
        mv.addObject("name", "jack");
        mv.setViewName("login");
        return mv;
    }
    /**
     * 功能描述:表格展示用户数据
     * @param:
     * @return:
     * @auther: chen
     * @date: 2018/10/24 16:47
     */
    @RequestMapping(value ="/center")
    public String center(ModelMap map){
        map.put("users",parseUsers());
        map.put("title","用户列表");
        return "center";
    }
    private List<Map> parseUsers(){
        List<Map> list= new ArrayList<>();
        List<User> users=userService.findAllUser(1,10);
        for(User user:users){
            Map map= new HashMap();
            map.put("id",user.getUserId());
            map.put("name",user.getUserName());
            map.put("password",user.getPassword());
            map.put("phone",user.getPhone());
            list.add(map);
        }
        return list;
    }
}
