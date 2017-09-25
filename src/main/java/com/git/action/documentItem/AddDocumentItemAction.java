package com.git.action.documentItem;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lihao on 17/9/25.
 */
public class AddDocumentItemAction extends ActionSupport {

    private long documentCatalogId;

    public long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public String showAdd() {

        return "showAdd";

    }

}
