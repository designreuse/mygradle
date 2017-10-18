package com.git.dao.impl;

import com.git.bean.DocumentCatalog;
import com.git.util.FileUtility;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.File;
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
        parent.setLeaf(false);
        child.setParent(parent);
        parent.getChildren().add(child);
        sessionFactory.getCurrentSession().save(child);

    }

    @Override
    public void saveChildDocumentCatalog(long parentId, DocumentCatalog child) {
        DocumentCatalog parent = this.getDocumentCatalog(parentId);
        parent.setLeaf(false);
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

    @Override
    public void deleteDocumentCatalog(long id) {
        DocumentCatalog bean = sessionFactory.getCurrentSession().get(DocumentCatalog.class, id);
        sessionFactory.getCurrentSession().delete(bean);
    }

    @Override
    public void deleteDocumentCatalog(File directory, long id) {
        DocumentCatalog bean = this.getDocumentCatalog(id);
        DocumentCatalog parent = bean.getParent();
        long parentId = -1;
        if(null !=parent){
            parentId = parent.getId();
        }

        if(null != parent) { //如果存在父亲，则尝试修改父亲的leaf 属性
            //必须要先解除父子关系才能完成后面的操作
            parent.getChildren().remove(bean);
            bean.setParent(null);

            if(0 == parent.getChildren().size()) { //将父亲修改为叶子节点
                bean.setLeaf(true);
                this.updateDocument(bean);
            }

        }
        if(bean.isFlag()) { //删除的为目录
            this.deleteDocumentItemsCascahe(id,directory);
        }

        //级联删除数据库中的记录
        this.deleteDocumentCatalog(id);



    }

    //删除硬盘是上的文件
    private void deleteDocumentItemsCascahe(Long documentCatalogId,File directory) {

        /**
         * 文件的存储方式是每个目录为 do目录cumentCatalogId 下面放文档
         * 孩子放到目录根 父亲节点存放的目录是平等的以孩子节点的id 为
         */
        File currentDirectory = new File(directory,String.valueOf(documentCatalogId));
        FileUtility.deleteAll(currentDirectory);

       Set<DocumentCatalog> children = this.getDocumentCatalog(documentCatalogId).getChildren();

       if(0 == children.size() ) {
           return;
       } else {
           children.forEach(document->{
              if(document.isFlag()) { // 如果是目录
                  this.deleteDocumentItemsCascahe(document.getId(),directory);
              }
           });
       }

    }

    @Override
    public void updateDocumentUpById(long id) {
        DocumentCatalog bean =  sessionFactory.getCurrentSession().get(DocumentCatalog.class,id);
        System.out.println("-------order = "+bean.getOrder());

        bean.setOrder(bean.getOrder()-1);
        sessionFactory.getCurrentSession().save(bean);



    }

    @Override
    public void updateDocumentDownById(long id) {
        DocumentCatalog bean =  sessionFactory.getCurrentSession().get(DocumentCatalog.class,id);
        bean.setOrder(bean.getOrder()+1);
        sessionFactory.getCurrentSession().save(bean);
    }

    @Override
    public void updateDocument(DocumentCatalog bean) {
        sessionFactory.getCurrentSession().update(bean);
    }
}
