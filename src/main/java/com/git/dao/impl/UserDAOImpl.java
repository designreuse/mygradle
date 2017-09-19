package com.git.dao.impl;

import com.git.bean.User;
import com.git.dao.UserDAO;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    @Override
    public void saveUser(User user) {
        this.getHibernateTemplate().save(user);

    }

    @Override
    public void removeUser(User user) {
        this.getHibernateTemplate().delete(user);

    }

    @Override
    public User findUserById(Integer userId) {
      User user =  this.getHibernateTemplate().get(User.class,userId);
      return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        String hql = "from User user order by user.id desc";


        return (List<User>) this.getHibernateTemplate().find(hql);
    }

    @Override
    public void updateUser(User user) {

        this.getHibernateTemplate().update(user);
    }
}
