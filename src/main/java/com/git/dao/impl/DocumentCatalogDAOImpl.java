package com.git.dao.impl;

import com.git.bean.DocumentCatalog;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by lixueqin on 2017/9/21.
 */
@Repository("documentCatalogDAO")
public class DocumentCatalogDAOImpl implements com.git.dao.DocumentCatalogDAO {

    @Resource
    private SessionFactory sessionFactory;


    @Override
    public DocumentCatalog getDocumentCatalog(Long id) {
        return sessionFactory.getCurrentSession().get(DocumentCatalog.class,id);
    }

    @Override
    public void saveDocumentCatalog(DocumentCatalog bean) {
        sessionFactory.getCurrentSession().save(bean);
    }

    @Override
    public void saveChildDocumentCatalog(DocumentCatalog parent, DocumentCatalog child) {
        //将瞬时状态的parent重新关联到另一个session上
        sessionFactory.openSession().load(parent, LockMode.NONE);

        child.setParent(parent);
        parent.getChildren().add(child);
        sessionFactory.getCurrentSession().save(child);

    }

    @Override
    public List<DocumentCatalog> listDocumentCatalogByTypeAndParentId(int type, long parentId) {
       if(-1 == parentId) {//父目录
           String hql = "from DocumentCatalog bean where bean.type=:types and bean.parent is null order by bean.order asc";
           List<DocumentCatalog> data = sessionFactory.getCurrentSession().createQuery(hql).setParameter("types",type).list();
            return data;

       } else { //子目录
           DocumentCatalog parent = sessionFactory.getCurrentSession().find(DocumentCatalog.class,parentId);
           // sessionFactory.openSession().load(parent, LockMode.NONE);
           Set<DocumentCatalog> sets = parent.getChildren();

          List<DocumentCatalog> data = new ArrayList<>();
          data.addAll(sets);

          return data;

       }


    }
}
