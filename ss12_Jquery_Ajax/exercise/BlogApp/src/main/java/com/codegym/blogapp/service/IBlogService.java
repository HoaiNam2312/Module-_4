package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    List<Blog> findByCategory_Id(int id);

    Blog save(Blog blog);

    void deleteById(int id);

    Blog findById(int id);


}
