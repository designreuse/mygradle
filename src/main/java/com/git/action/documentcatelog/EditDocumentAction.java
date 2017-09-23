package com.git.action.documentcatelog;

import com.git.bean.DocumentCatalog;
import com.git.service.DocumentCatalogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by lixueqin on 2017/9/23.
 */
public class EditDocumentAction extends ActionSupport {

    private String title;
    private String description;
    private String address;
    private int order;

    private int type;
    private Long parentId;
    private Long id;
    private boolean flag;

    DocumentCatalog bean;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Resource
    DocumentCatalogService documentCatalogService;

    public String updateShow() {
        bean = documentCatalogService.getDocumentCatalog(id);
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        request.put("document",bean);
        request.put("parentId",parentId);



        return "updateShow";
    }

    public String update() {
       bean = documentCatalogService.getDocumentCatalog(id);
        bean.setOrder(order);
        bean.setName(title);
       if(!flag) {//连接
           bean.setContent(description);
           bean.setAddress(address);
       }


       documentCatalogService.updateDocument(bean);
        return "update";
    }

}
