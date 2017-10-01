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
    public void deleteDocumentItemById(  long itemid) {

            documentItemDAO.deleteDocumentItemById(itemid);


    }

    @Override
    @Transactional
    public DocumentitemEntity getDocumentItemById(long itemid) {
        return documentItemDAO.getDocumentItemById(itemid);
    }

    @Override
    public String getIconType(String type) {
        String icon = null;
        if("doc".equalsIgnoreCase(type) || "docx".equalsIgnoreCase(type)) {
            icon = "word.png";
        } else if("jpg".equalsIgnoreCase(type) || "png".equalsIgnoreCase(type) ||  "jpeg".equalsIgnoreCase(type)
                ||  "gif".equalsIgnoreCase(type)) {
            icon = "pic.png";
        } else if("pdf".equalsIgnoreCase("pdf")) {
            icon = "pdf.png";

        } else if("mp3".equalsIgnoreCase(type) || "mp4".equalsIgnoreCase(type) || "avi".equalsIgnoreCase(type)|| "wmv".equalsIgnoreCase(type)) {
            icon = "media.png";

        } else if("txt".equalsIgnoreCase(type) || "log".equalsIgnoreCase(type)|| "md".equalsIgnoreCase(type)) {
            icon = "txt.png";

        } else if("xls".equalsIgnoreCase(type) || "xlsx".equalsIgnoreCase(type)) {
            icon = "xls.png";

        } else if("pdf".equalsIgnoreCase(type)) {

            icon = "doc.png";
        } else if("zip".equalsIgnoreCase(type) || "rar".equalsIgnoreCase(type) || "gz".equalsIgnoreCase(type)) {
            icon = "zip.png";
        } else {
            icon = "orther.png";
        }

        return icon;

    }

    @Override
    @Transactional
    public void updateDocumentItem(DocumentitemEntity entity) {
        documentItemDAO.updateDocumentItem(entity);
    }

    @Override
    @Transactional
    public List<DocumentitemEntity> listDocumentItmesBySort(long documentCatalogId, String filed, String away) {
        return documentItemDAO.listDocumentItmesBySort(documentCatalogId,filed,away);
    }

}
