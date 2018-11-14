package com.chen.springbootdemo.service.impl;

import com.chen.springbootdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "userService")
@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响
    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     *这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum:开始页数
     * @param pageSize：每页显示的条数
     * @return
     */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
