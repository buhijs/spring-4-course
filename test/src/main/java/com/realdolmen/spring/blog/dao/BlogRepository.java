package com.realdolmen.spring.blog.dao;

import com.realdolmen.spring.blog.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cda5732 on 14/04/2015.
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
