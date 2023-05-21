package com.zxy.service.impl;

import com.zxy.entity.User;
import com.zxy.mapper.TranMapper;
import com.zxy.mapper.UserMapper;
import com.zxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    @Override
    public User searchUser(String Uname) {
        return userMapper.searchUser(Uname);
    }

    @Override
    public int haveUser(String Uname) {
        return userMapper.haveUser(Uname);
    }
}
