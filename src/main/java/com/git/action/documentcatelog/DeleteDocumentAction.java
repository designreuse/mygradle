package com.git.action.documentcatelog;

import com.git.service.DocumentCatalogService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lixueqin on 2017/9/22.
 */
public class DeleteDocumentAction extends ActionSupport {
    private Long id;

    private long parentId;
    private int type;



    private DocumentCatalogService documentCatalogService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentCatalogService getDocumentCatalogService() {
        return documentCatalogService;
    }

    public void setDocumentCatalogService(DocumentCatalogService documentCatalogService) {
        this.documentCatalogService = documentCatalogService;
    }

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

    @Override
    public String execute() throws Exception {
        documentCatalogService.deleteDocumentCatalog(id);
        return "success";
    }
}
