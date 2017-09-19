package com.git.dao.impl;

import com.git.bean.User;
import com.git.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Repository("userDAO")
public class UserDAOImpl  implements UserDAO {

    @Resource
    private SessionFactory sessionFactory;
    @Override
    public void saveUser(User user) {
        System.out.println("UserDAOImpl ==== ");
//        this.getHibernateTemplate().save(user);
        Session session = sessionFactory.getCurrentSession();
        session.save(user);



    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public User findUserById(Integer userId) {
      return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        String hql = "from User user order by user.id desc";

        return null;
    }

    @Override
    public void updateUser(User user) {

    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
