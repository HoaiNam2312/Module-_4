package com.codegym.blogapp.service.category;

import com.codegym.blogapp.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void remove(int id);
}
