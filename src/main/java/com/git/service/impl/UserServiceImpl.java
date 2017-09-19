package com.git.service.impl;

import com.git.bean.User;
import com.git.dao.UserDAO;
import com.git.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    @Transactional
    public void save(User user) {
        System.out.println("UserServiceImpl ==== ");
        userDAO.saveUser(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }


}
