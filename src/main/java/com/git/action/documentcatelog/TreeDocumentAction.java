package com.git.action.documentcatelog;

import com.git.bean.DocumentCatalog;
import com.git.bean.DocumentitemEntity;
import com.git.service.DocumentCatalogService;
import com.git.service.DocumentItemService;
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

    private long parentId;
    private int type;
    private String parentName;
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Resource
    private DocumentCatalogService documentCatalogService;
    @Resource
    DocumentItemService documentItemService;


    @Override
    public String execute() throws Exception {
        List<DocumentCatalog> list = documentCatalogService.listDocumentCatalogByTypeAndParentId(type, parentId);

        System.out.println("----------------->parentId=" + parentId);
        List<Tree> trees = new ArrayList<>();
        list.forEach(documentCatalog -> {
            Tree tree = new Tree();
            tree.setChildren(true);
            if(documentCatalog.isLeaf()) {
                tree.setChildren(false);
            }

            tree.setIcon("jstree-folder");
            tree.setParentId(documentCatalog.getId());
            tree.setType("folder");

            if (!StringUtils.isBlank(id)) {
                id = id.replaceAll("#/", "");
                tree.setId(id + "/" + documentCatalog.getName());
                tree.setParentName(id + "/" + documentCatalog.getName());
            } else {
                tree.setId(documentCatalog.getName());
            }


            tree.setText(documentCatalog.getName());
            trees.add(tree);


        });
        if (-1 != parentId) {
            System.out.println("----------------->"+parentId);
            List<DocumentitemEntity> items = documentItemService.listDocumentItmesBySort(parentId, "id", "desc");
            items.forEach(item -> {
                Tree tree2 = new Tree();
                tree2.setChildren(false);
                tree2.setIcon("jstree-file");

                tree2.setType("file");
                if (!StringUtils.isBlank(id)) {
                    id = id.replaceAll("#/", "");
                    tree2.setId(id + "/" + item.getName());
                } else {
                    tree2.setId(item.getName());
                }
                tree2.setText(item.getName());

                trees.add(tree2);

            });
        }


        Gson gson = new Gson();
        String json = gson.toJson(trees);
        System.out.println(json);

        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
        return null;
    }
}
