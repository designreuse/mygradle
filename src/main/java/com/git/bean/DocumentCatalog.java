package com.git.bean;

import java.util.Date;
import java.util.Set;

/**
 * Created by lixueqin on 2017/9/21.
 */
public class DocumentCatalog {
    private Long id;
    private String name;
    private DocumentCatalog parent;
    private Set<DocumentCatalog> children;
    private Date date;
    private boolean flag;
    private Long authorId;
    private String authorName;
    private Integer type;
    private Integer order;
    private String content;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentCatalog getParent() {
        return parent;
    }

    public void setParent(DocumentCatalog parent) {
        this.parent = parent;
    }

    public Set<DocumentCatalog> getChildren() {
        return children;
    }

    public void setChildren(Set<DocumentCatalog> children) {
        this.children = children;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
