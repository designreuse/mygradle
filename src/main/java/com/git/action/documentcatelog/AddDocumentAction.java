package com.git.action.documentcatelog;

import com.git.bean.DocumentCatalog;
import com.git.service.DocumentCatalogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * Created by lixueqin on 2017/9/21.
 */
public class AddDocumentAction extends ActionSupport {

    private String title;
    private String choice;
    private String title2;
    private String description;
    private String address;
    private int order;

    private int type;
    private Long parentId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Resource
    private DocumentCatalogService documentCatalogService;

    public DocumentCatalogService getDocumentCatalogService() {
        return documentCatalogService;
    }

    public void setDocumentCatalogService(DocumentCatalogService documentCatalogService) {
        this.documentCatalogService = documentCatalogService;
    }



    public String showAdd() {
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

        request.put("type",type);
        request.put("parentId",parentId);

        return "showadd";
    }


    public String save() throws Exception {


        DocumentCatalog bean = new DocumentCatalog();
        bean.setDate(new Date());
        bean.setOrder(order);
        bean.setType(type);
        bean.setAuthorId(1l);
        bean.setAuthorName("lihao");


        if("directory".equals(choice)) { //目录

            bean.setName(title);
            bean.setFlag(true);

        } else { //连接
            bean.setFlag(false);
            bean.setName(title2);
            bean.setContent(description);
            bean.setAddress(address);
        }


        if(-1 != parentId) { //子目录

            DocumentCatalog parent = this.documentCatalogService.getDocumentCatalog(parentId);
            this.documentCatalogService.saveChildDocumentCatalog(parent,bean);

        } else {
            documentCatalogService.saveDocumentCatalog(bean);
        }


        return "success";
    }
}
