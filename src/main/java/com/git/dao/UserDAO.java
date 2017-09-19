package com.git.dao;

import com.git.bean.User;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
public interface UserDAO {
    void saveUser(User user);

    void removeUser(User user);

    User findUserById(Integer userId);

    List<User> findAllUsers();

    void updateUser(User user);
}
