package com.git.service.impl;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentitemEntity;
import com.git.dao.DocumentCatalogDAO;
import com.git.dao.DocumentItemDAO;
import com.git.service.DocumentCatalogService;
import com.git.service.DocumentItemService;
import com.git.util.FileStorage;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/21.
 */
@Service("documentItemService")
public class DocumentItemServiceImpl implements DocumentItemService {

    @Resource
    DocumentItemDAO documentItemDAO;


    @Override
    @Transactional
    public List<DocumentitemEntity> listDocumentItmesByDocumentCatalogId(long documentCatalogId) {
        return documentItemDAO.listDocumentItmesByDocumentCatalogId(documentCatalogId);
    }

    @Override
    @Transactional
    public boolean isDocumentItemExistByDcomentCatalogIdAndName(long documentCatalogId, String name) {
        return documentItemDAO.isDocumentItemExistByDcomentCatalogIdAndName(documentCatalogId,name);
    }

    @Override
    @Transactional
    public void saveDocumentItems(DocumentCatalog documentCatalog, List<DocumentitemEntity> items) {
        documentItemDAO.saveDocumentItems(documentCatalog,items);
    }

    @Override
    @Transactional
    public void deleteDocumentItemById(HttpServletRequest request, long documentCatalogId, List<Long> itemIds) {
        itemIds.forEach(id->{
            documentItemDAO.deleteDocumentItemById(request,id,documentCatalogId);

        });
    }
}
