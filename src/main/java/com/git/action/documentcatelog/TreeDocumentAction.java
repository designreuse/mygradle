package com.git.action.documentcatelog;

import com.git.bean.DocumentCatalog;
import com.git.service.DocumentCatalogService;
import com.git.tree.Tree;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TreeDocumentAction extends ActionSupport {

    private long parentId ;
    private int type;
    private String parentName;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Resource
    private DocumentCatalogService documentCatalogService;


    @Override
    public String execute() throws Exception {
        List<DocumentCatalog> list = documentCatalogService.listDocumentCatalogByTypeAndParentId(type, parentId);

        System.out.println("----------------->parentId="+parentId);
        List<Tree> trees = new ArrayList<>();
        list.forEach(documentCatalog -> {
            Tree tree = new Tree();
            tree.setChildren(true);
            tree.setIcon("jstree-folder");
            tree.setParentId(documentCatalog.getId());
            if(!StringUtils.isBlank(parentName)) {
                tree.setId(parentName+"/"+documentCatalog.getName());
                tree.setParentName(parentName+"/"+documentCatalog.getName());
            }
//            else {
//                tree.setId(documentCatalog.getName());
//            }


            tree.setText(documentCatalog.getName());
            trees.add(tree);
        });


        Gson gson = new Gson();
        String json = gson.toJson(trees);
        System.out.println(json);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        return null;
    }
}
