package com.zxy.mapper;

import com.zxy.entity.User;

public interface UserMapper {
    void insertUser(User user);
    User searchUser(String Uname);
    int haveUser(String Uname);
}
