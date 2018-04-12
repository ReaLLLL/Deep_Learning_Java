package com.maowei.learning.orm.dao;

import com.maowei.learning.orm.User;

public interface UserDao {
    User findUserById(String id);

    Integer updateUserById(User user);

    Integer deleteUserById(String id);

    Integer addUser(User user);
}
