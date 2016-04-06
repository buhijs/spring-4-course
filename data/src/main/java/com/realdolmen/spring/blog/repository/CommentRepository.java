package com.realdolmen.spring.blog.repository;

import com.realdolmen.spring.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findFirst50ByBlogPost_IdOrderByCreationDateDesc(Long blogPostId);
}
