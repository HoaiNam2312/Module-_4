package com.codegym.blogapp.service.blog;

import com.codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll(int quantity);

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    List<Blog> findByNameContaining(String searchName);

//    Page<Blog> search(String searchName);
//    Page<Blog> searchCategory(Integer id, Pageable pageable);
//
//    Page<Blog> searchNameAnhCategory(String searchName, Integer id, Pageable pageable);
}
