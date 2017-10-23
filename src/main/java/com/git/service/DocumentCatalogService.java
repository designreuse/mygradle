package com.git.service;

import com.git.bean.DocumentCatalog;
import com.git.exception.EngineException;

import java.io.File;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
public interface DocumentCatalogService {
     DocumentCatalog getDocumentCatalog(Long id);

     void saveDocumentCatalog(DocumentCatalog bean);

     void saveChildDocumentCatalog(DocumentCatalog parent, DocumentCatalog child);
     void saveChildDocumentCatalog(long parentId, DocumentCatalog child);

     List<DocumentCatalog> listDocumentCatalogByTypeAndParentId(int type, long parentId);
     void deleteDocumentCatalog(long id) throws EngineException;
     void deleteDocumentCatalog(File directgiory,long id) throws EngineException;

     void updateDocumentUpById(long id);
     void updateDocumentDownById(long id);

     void updateDocument(DocumentCatalog bean);
}
