package com.git.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lixueqin on 2017/9/24.
 */
@Entity
@Table(name = "documentitem", schema = "arch1", catalog = "")
public class DocumentitemEntity {
    private long id;
    private String name;
    private Long authorId;
    private String authorName;
    private Timestamp date;
    private Long documentCatalogId;
    private Long realSize;
    private String size;
    private String randomName;
    private String type;

    private DocumentCatalog documentCatalog;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name_", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "authorId_", nullable = true)
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "authorName_", nullable = false, length = 50)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "date_", nullable = true)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "documentCatalogId_", nullable = true)
    public Long getDocumentCatalogId() {
        return documentCatalogId;
    }

    public void setDocumentCatalogId(Long documentCatalogId) {
        this.documentCatalogId = documentCatalogId;
    }

    @Basic
    @Column(name = "realSize_", nullable = true)
    public Long getRealSize() {
        return realSize;
    }

    public void setRealSize(Long realSize) {
        this.realSize = realSize;
    }

    @Basic
    @Column(name = "size_", nullable = true, length = 50)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "randomName_", nullable = true, length = 50)
    public String getRandomName() {
        return randomName;
    }

    public void setRandomName(String randomName) {
        this.randomName = randomName;
    }

    @Basic
    @Column(name = "type_", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentitemEntity that = (DocumentitemEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (authorId != null ? !authorId.equals(that.authorId) : that.authorId != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (documentCatalogId != null ? !documentCatalogId.equals(that.documentCatalogId) : that.documentCatalogId != null)
            return false;
        if (realSize != null ? !realSize.equals(that.realSize) : that.realSize != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (randomName != null ? !randomName.equals(that.randomName) : that.randomName != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (authorId != null ? authorId.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (documentCatalogId != null ? documentCatalogId.hashCode() : 0);
        result = 31 * result + (realSize != null ? realSize.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (randomName != null ? randomName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public DocumentCatalog getDocumentCatalog() {
        return documentCatalog;
    }

    public void setDocumentCatalog(DocumentCatalog documentCatalog) {
        this.documentCatalog = documentCatalog;
    }
}
