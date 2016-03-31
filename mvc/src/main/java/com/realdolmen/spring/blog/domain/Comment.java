package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Lob
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date creationDate;
    @Column(nullable = false, length = 100)
    private String authorName;

    @ManyToOne
    private BlogPost blogPost;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    @PrePersist
    public void createComment() {
        setCreationDate(new Date());
    }
}
