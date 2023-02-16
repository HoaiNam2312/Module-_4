package com.codegym.blogapp.service;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository iBlogRepository;


    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
}

    @Override
    public Blog findById(int id) {
       return iBlogRepository.findById(id).orElse(null);
    }


    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }
}
