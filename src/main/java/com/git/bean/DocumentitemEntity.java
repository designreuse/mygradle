package com.git.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by lixueqin on 2017/9/24.
 */
@Entity
public class DocumentitemEntity {
    private long id;
    private String name;
    private Long authorId;
    private String authorName;
    private Date date;
    private Long documentCatalogId;
    private Long realSize;
    private String size;
    private String randomName;
    private String type;

    private DocumentCatalog documentCatalog;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(Long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    public Long getRealSize() {
        return realSize;
    }

    public void setRealSize(Long realSize) {
        this.realSize = realSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRandomName() {
        return randomName;
    }

    public void setRandomName(String randomName) {
        this.randomName = randomName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public DocumentCatalog getDocumentCatalog() {
        return documentCatalog;
    }

    public void setDocumentCatalog(DocumentCatalog documentCatalog) {
        this.documentCatalog = documentCatalog;
    }
}
