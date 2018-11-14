package com.chen.springbootdemo.service;





import com.winter.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);
    List<User> findAllUser(int pageNum, int pageSize);
}
