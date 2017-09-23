package com.git.action.documentcatelog;

import com.git.service.DocumentCatalogService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;

/**
 * Created by lixueqin on 2017/9/23.
 */
public class OrderDocumentAction extends ActionSupport {
    private Long id;

    private long parentId;
    private int type;

    @Resource
    DocumentCatalogService documentCatalogService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public String up() {
        System.out.println("-------up");
        documentCatalogService.updateDocumentUpById(id);
        return "up";

    }


    public String down() {
        documentCatalogService.updateDocumentDownById(id);
        return "down";
    }



}
