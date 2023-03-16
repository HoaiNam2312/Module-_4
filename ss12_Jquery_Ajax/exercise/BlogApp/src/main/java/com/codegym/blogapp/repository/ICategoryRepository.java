package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
