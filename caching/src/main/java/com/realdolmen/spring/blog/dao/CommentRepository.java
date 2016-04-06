package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cda5732 on 14/04/2015.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findFirst50ByBlogPost_IdOrderByCreationDateDesc(Long id);
}
