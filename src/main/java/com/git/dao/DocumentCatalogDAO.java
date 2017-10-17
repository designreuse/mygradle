package com.git.dao;

import com.git.bean.DocumentCatalog;
import org.omg.CORBA.portable.ValueOutputStream;

import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
public interface DocumentCatalogDAO {
     DocumentCatalog getDocumentCatalog(Long id);

     void saveDocumentCatalog(DocumentCatalog bean);

     void saveChildDocumentCatalog(DocumentCatalog parent,DocumentCatalog child);
     void saveChildDocumentCatalog(long parentId,DocumentCatalog child);



     List<DocumentCatalog> listDocumentCatalogByTypeAndParentId(int type, long parentId);

     void deleteDocumentCatalog(long id);

     void updateDocumentUpById(long id);
     void updateDocumentDownById(long id);
     void updateDocument(DocumentCatalog bean);


}
