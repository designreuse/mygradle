package com.git.action.documentItem;

import com.git.bean.DocumentitemEntity;
import com.git.service.DocumentItemService;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by lixueqin on 2017/9/24.
 */
public class ListDocumentItemAction extends ActionSupport {

    @Resource
    DocumentItemService documentItemService;

    private long documentCatalogId;

    private List<DocumentitemEntity> list;


    private File file;

    public long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public List<DocumentitemEntity> getList() {
        return list;
    }

    public void setList(List<DocumentitemEntity> list) {
        this.list = list;
    }

    @Override
    public String execute() throws Exception {
        setList(documentItemService.listDocumentItmesByDocumentCatalogId(documentCatalogId));
        list.forEach(bean->{
            bean.setIconType(documentItemService.getIconType(bean.getType()));
        });
        return "success";
    }
}
