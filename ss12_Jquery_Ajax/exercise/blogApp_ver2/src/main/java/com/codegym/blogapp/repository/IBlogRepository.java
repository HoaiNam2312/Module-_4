package com.codegym.blogapp.repository;

import com.codegym.blogapp.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {


    List<Blog> findByNameContaining(String searchName);

    @Query(value = "select * from blog limit :quantity", nativeQuery = true)
    List<Blog> getBlogList(Integer quantity);

//    Page<Blog> findByCategory_Id(Integer id, Pageable pageable);
//
//    Page<Blog> findByNameContainingAndCategory_Id(String searchNam, Integer id, Pageable pageable);
}
