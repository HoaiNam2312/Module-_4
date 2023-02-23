package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String searchName, Pageable pageable);

    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);

    Page<Blog> findByNameContainingAndCategory_Id(String searchNam, Integer id, Pageable pageable);
}
