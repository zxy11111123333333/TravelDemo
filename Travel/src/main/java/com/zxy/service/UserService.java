package com.zxy.service;

import com.zxy.entity.User;

public interface UserService {
    void insertUser(User user);
    User searchUser(String Uname);
    int haveUser(String Uname);
}
