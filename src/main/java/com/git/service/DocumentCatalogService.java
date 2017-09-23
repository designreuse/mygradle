package com.git.service;

import com.git.bean.DocumentCatalog;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
public interface DocumentCatalogService {
     DocumentCatalog getDocumentCatalog(Long id);

     void saveDocumentCatalog(DocumentCatalog bean);

     void saveChildDocumentCatalog(DocumentCatalog parent, DocumentCatalog child);

     List<DocumentCatalog> listDocumentCatalogByTypeAndParentId(int type, long parentId);
     void deleteDocumentCatalog(long id);

     void updateDocumentUpById(long id);
     void updateDocumentDownById(long id);

     void updateDocument(DocumentCatalog bean);
}
