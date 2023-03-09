package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category save(Category category);

    void deleteById(int id);

    Category findById(int id);
}
