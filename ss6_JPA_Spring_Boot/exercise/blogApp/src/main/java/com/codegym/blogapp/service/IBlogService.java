package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);
}
