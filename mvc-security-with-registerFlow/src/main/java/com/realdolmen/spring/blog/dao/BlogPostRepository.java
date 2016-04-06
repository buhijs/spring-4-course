package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Blog;
import com.realdolmen.spring.blog.domain.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cda5732 on 14/04/2015.
 */
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    Page<Blog> findAllByOrderByCreationDateDesc(Pageable pageable);
}
