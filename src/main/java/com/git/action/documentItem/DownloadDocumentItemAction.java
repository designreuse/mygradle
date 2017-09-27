package com.git.action.documentItem;

import com.git.bean.DocumentitemEntity;
import com.git.service.DocumentItemService;
import com.git.util.FileStorage;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by lixueqin on 2017/9/27.
 */
public class DownloadDocumentItemAction extends ActionSupport {
    private long documentItemId;
    private DocumentItemService documentItemService;

    private String filename;


    public long getDocumentItemId() {
        return documentItemId;
    }

    public void setDocumentItemId(long documentItemId) {
        this.documentItemId = documentItemId;
    }

    public DocumentItemService getDocumentItemService() {
        return documentItemService;
    }

    public void setDocumentItemService(DocumentItemService documentItemService) {
        this.documentItemService = documentItemService;
    }

    public String getFilename() throws UnsupportedEncodingException {
        return new String(filename.getBytes(), "ISO8859-1");

    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getDownloadFile() {
        HttpServletRequest request = ServletActionContext.getRequest();
        DocumentitemEntity bean = documentItemService.getDocumentItemById(documentItemId);

        filename = bean.getName();
       long documentCatalogId = bean.getDocumentCatalog().getId();
        File file = new File(FileStorage.getDocumentItemStorage(request) + File.separator + documentCatalogId + File.separator + bean.getRandomName());

        InputStream ins = null;
        try {
            ins = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return ins;

    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
