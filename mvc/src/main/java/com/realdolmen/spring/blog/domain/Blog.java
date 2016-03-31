package com.realdolmen.spring.blog.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Entity
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @Column(length = 255, nullable = false)
    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date creationDate;

    @OneToOne
    @JoinColumn(nullable = false, unique = true)
    private Author author;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @PrePersist
    public void createBlog() {
        setCreationDate(new Date());
    }
}
