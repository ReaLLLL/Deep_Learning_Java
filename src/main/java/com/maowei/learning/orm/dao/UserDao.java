package com.maowei.learning.orm.dao;

import com.maowei.learning.orm.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User findUserById(String id);

    List<User> queryUserByPage(Map<String,Object> data);

    Integer updateUserById(User user);

    Integer deleteUserById(String id);

    Integer addUser(User user);
}
