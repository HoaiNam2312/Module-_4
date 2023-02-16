package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

}
