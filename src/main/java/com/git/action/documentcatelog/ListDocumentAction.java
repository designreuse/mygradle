package com.git.action.documentcatelog;

import com.git.service.DocumentCatalogService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

/**
 * Created by lixueqin on 2017/9/22.
 */
public class ListDocumentAction extends ActionSupport {
    private long parentId;
    private int type;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Resource
    private DocumentCatalogService documentCatalogService;

    public DocumentCatalogService getDocumentCatalogService() {
        return documentCatalogService;
    }

    public void setDocumentCatalogService(DocumentCatalogService documentCatalogService) {
        this.documentCatalogService = documentCatalogService;
    }


    @Override
    public String execute() throws Exception {
        documentCatalogService.listDocumentCatalogByTypeAndParentId(type,parentId);
        return super.execute();
    }
}
