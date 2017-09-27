package com.git.action.documentItem;

import com.git.service.DocumentItemService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lihao on 17/9/27.
 */
public class DeleteDocumentItemAction extends ActionSupport {
    private List<Long> ids;
    private long documentCatalogId;
    private long action;

    @Resource
    DocumentItemService documentItemService;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public long getAction() {
        return action;
    }

    public void setAction(long action) {
        this.action = action;
    }

    @Override
    public String execute() throws Exception {

        HttpServletRequest request = ServletActionContext.getRequest();

//        System.out.println(ids);

        documentItemService.deleteDocumentItemById(request,documentCatalogId,ids);

        return SUCCESS;
    }
}
