package com.git.dao.impl;

import com.git.bean.User;
import com.git.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/19.
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

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
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User findUserById(Integer userId) {
        return sessionFactory.getCurrentSession().find(User.class,userId);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> findAllUsers() {
        String hql = " from User user order by user.id desc ";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<User> data = query.getResultList();

        return data;
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);

    }

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
