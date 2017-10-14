package com.git.util;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class BaseDAO<T> {
    @Resource
    protected SessionFactory sessionFactory;


    /**
     * 删除id
     *
     * @param c
     * @param id
     */
    protected void removeObj(Class<T> c, Long id) {
        T obj = (T) this.getSession().get(c, id);
        this.getSession().delete(obj);
    }

    protected void removeObjs(Class<T> c,List<Long> ids) {
        if(null !=ids && ids.size()>0) {
            ids.forEach(id->{
                removeObj(c,id);
            });
        }

    }

    //update
    protected void updateObj(T obj){
        this.getSession().update(obj);
    }

    protected void updateObjs(List<T> objs) {
        if(null != objs && objs.size()>0) {
            objs.forEach(obj->{
                updateObj(obj);
            });
        }
    }



    /**
     * 根据id 获取对象
     *
     * @param c
     * @param id
     * @return
     */
    protected T retrieveObj(Class<T> c, Long id) {
        return (T) this.getSession().get(c, id);
    }

    /**
     * 不带参数的query 查询
     *
     * @param queryString
     * @return
     */
    protected List<T> retrieveObjs(String queryString) {
        return this.getQuery(queryString).list();

    }


    /**
     * 带参数的查询
     *
     * @param queryString
     * @param params
     * @return
     */
    protected List<T> retrieveObjs(String queryString, Map<String, Object> params) {

        Query query = this.getQuery(queryString);
        if (null != params && params.size()>0) {
            params.forEach((key, value) -> {
                query.setParameter(key, value);
            });
        }


        return query.list();
    }


    protected List<T> retrieveObjs(String queryString, String key, Object value) {

        Query query = this.getQuery(queryString);
        query.setParameter(key, value);


        return query.list();
    }


    /**
     * 分页查询
     *
     * @param queryString
     * @param params
     * @param start
     * @param number
     * @return
     */
    protected List<T> retrievePageObjs(String queryString, Map<String, Object> params, int start, int number) {
        Query query = this.getQuery(queryString);
        if (null != params && params.size()>0) {
            params.forEach((key, value) -> {
                query.setParameter(key, value);
            });
        }
        query.setFirstResult(start);
        query.setMaxResults(number);
        return query.list();
    }


    /**
     * 带参数的查询
     *
     * @param queryString
     * @param params
     * @return
     */
    protected T retrieveObj(String queryString, Map<String, Object> params) {

        Query query = this.getQuery(queryString);
        if (null != params && params.size()>0) {
            params.forEach((key, value) -> {
                query.setParameter(key, value);
            });

        }

        List<T> list = query.list();
        return getFirst(list);

    }

    protected T retrieveObj(String queryString) {
        Query query = this.getQuery(queryString);

        List<T> list = query.list();
        return getFirst(list);

    }

    protected T retrieveObj(String queryString, String key, Object value) {

        Query query = this.getQuery(queryString);
        query.setParameter(key, value);


        List<T> list = query.list();
        return getFirst(list);

    }

    private T getFirst(List<T> list) {
        if (Optional.ofNullable(list).isPresent()) {

            if (null == list.get(0)) {
                return null;
            } else {
                return list.get(0);
            }
        } else {
            return null;
        }
    }


    protected long retrieveObjsCount(String queryString, Map<String, Object> params) {
        Query query = this.getQuery("select count(*) " + queryString);
        if (null != params && params.size()>0) {
            params.forEach((key, value) -> {
                query.setParameter(key, value);
            });

        }

        return (long) query.iterate().next();

    }

    protected long retrieveObjsCount(String queryString, String key, Object value) {
        Query query = this.getQuery("select count(*) " + queryString);
        query.setParameter(key, value);

        return (long) query.iterate().next();

    }

    protected long retrieveObjsCount(String queryString) {
        Query query = this.getQuery("select count(*) " + queryString);

        return (long) query.iterate().next();

    }

    protected void storeObj(T obj) {
        this.getSession().saveOrUpdate(obj);
    }

    protected void storeObjs(List<T> objs) {
        if (null != objs) {
            objs.forEach(obj -> {
                this.storeObj(obj);
            });
        }

    }


    /**
     * 获取session
     *
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获取到query
     *
     * @param queryString
     * @return
     */
    protected Query getQuery(String queryString) {
        return this.getSession().createQuery(queryString);


    }

}
