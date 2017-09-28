package com.git.dao.impl;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentitemEntity;
import com.git.dao.DocumentItemDAO;
import com.git.util.FileStorage;
import org.apache.commons.io.FileUtils;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lixueqin on 2017/9/21.
 */
@Repository("documentItemDAO")
public class DocumentItemDAOImpl implements DocumentItemDAO {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<DocumentitemEntity> listDocumentItmesByDocumentCatalogId(long documentCatalogId) {
        String hql = "from DocumentitemEntity bean where bean.documentCatalog.id=:documentCatalogId order by bean.id desc";
        List<DocumentitemEntity> data = sessionFactory.getCurrentSession().createQuery(hql).setParameter("documentCatalogId", documentCatalogId).getResultList();
        return data;
    }

    @Override
    public boolean isDocumentItemExistByDcomentCatalogIdAndName(long documentCatalogId, String name) {
        String hql = "from DocumentitemEntity bean where bean.documentCatalog.id=:documentCatalogId and bean.name=:name";
        List<DocumentitemEntity> data = sessionFactory.getCurrentSession().createQuery(hql)
                .setParameter("documentCatalogId", documentCatalogId)
                .setParameter("name", name).list();
        if (data != null && data.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void saveDocumentItems(DocumentCatalog documentCatalog, List<DocumentitemEntity> items) {
        Session session = sessionFactory.getCurrentSession();
//        session.lock(documentCatalog, LockMode.NONE);

        Set<DocumentitemEntity> set = new HashSet<>(items);
        documentCatalog.setItems(set);


        for (DocumentitemEntity entity : items) {

            entity.setDocumentCatalog(documentCatalog);
            session.save(entity);
            session.flush();
            session.clear();

        }


    }

    @Override
    public void deleteDocumentItemById(long id) {
        Session session = sessionFactory.getCurrentSession();
        DocumentitemEntity bean = session.get(DocumentitemEntity.class, id);
        session.delete(bean);

    }

    @Override
    public DocumentitemEntity getDocumentItemById(long itemid) {
        Session session = sessionFactory.getCurrentSession();
        DocumentitemEntity bean = session.get(DocumentitemEntity.class, itemid);
        return bean;
    }

    @Override
    public void updateDocumentItem(DocumentitemEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);

    }


}
