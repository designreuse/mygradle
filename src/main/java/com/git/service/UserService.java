package com.git.service;

import com.git.bean.User;

import java.io.InputStream;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
public interface UserService {
    public List<User> findAll();

    void save(User user);

    void delete(User user);

    void update(User user);

    User findById(Integer id);

    InputStream getInputStram();

}
