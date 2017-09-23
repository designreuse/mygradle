package com.git.service.impl;

import com.git.bean.DocumentCatalog;
import com.git.dao.DocumentCatalogDAO;
import com.git.service.DocumentCatalogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
@Service("documentCatalogService")
public class DocumentCatalogServiceImpl implements DocumentCatalogService {

    @Resource
    DocumentCatalogDAO documentCatalogDAO;

    @Override
    @Transactional
    public DocumentCatalog getDocumentCatalog(Long id) {
        return documentCatalogDAO.getDocumentCatalog(id);
    }

    @Override
    @Transactional
    public void saveDocumentCatalog(DocumentCatalog bean) {
        documentCatalogDAO.saveDocumentCatalog(bean);
    }

    @Override
    @Transactional
    public void saveChildDocumentCatalog(DocumentCatalog parent, DocumentCatalog child) {
        documentCatalogDAO.saveChildDocumentCatalog(parent,child);
    }

    @Override
    @Transactional
    public List<DocumentCatalog> listDocumentCatalogByTypeAndParentId(int type, long parentId) {
        return documentCatalogDAO.listDocumentCatalogByTypeAndParentId(type,parentId);
    }

    @Override
    @Transactional
    public void deleteDocumentCatalog(long id) {
        documentCatalogDAO.deleteDocumentCatalog(id);
    }

    @Override
    @Transactional
    public void updateDocumentUpById(long id) {
        documentCatalogDAO.updateDocumentUpById(id);
    }

    @Override
    @Transactional
    public void updateDocumentDownById(long id) {
        documentCatalogDAO.updateDocumentDownById(id);
    }

    @Override
    @Transactional
    public void updateDocument(DocumentCatalog bean) {
        documentCatalogDAO.updateDocument(bean);

    }
}
