package com.chen.springbootdemo.mappertest;

import com.winter.mapper.UserMapper;

import com.winter.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: chen
 * @Date: 2018/12/10 15:07
 * @Description:
 */
@RunWith(SpringRunner.class)//使用springboot的测试环境
@SpringBootTest//启动springboot项目
public class UserTest {

    @Autowired//自动装配
    private UserMapper userMapper;
    @Test
    public void testAutowired() throws Exception{

        User user = userMapper.selectByPrimaryKey(1001);
        System.out.println(user.getUserName());
    }

}
