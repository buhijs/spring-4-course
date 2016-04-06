package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Entity
public class BlogPost implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Column(unique = true, nullable = false)
    private String title;
    @Lob
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedDate;

    @ManyToOne
    private Blog blog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @PrePersist
    @PreUpdate
    public void updateBlogPost() {
        Date now = new Date();
        if (creationDate == null) {
            setCreationDate(now);
        }
        setUpdatedDate(now);
    }
}
