package com.codegym.blogapp.service.blog;

import com.codegym.blogapp.model.Blog;
import com.codegym.blogapp.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {

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

    @Override
    public Page<Blog> search(String searchName, Pageable pageable) {
        return iBlogRepository.findByNameContaining(searchName,pageable);
    }

    @Override
    public Page<Blog> searchCategory(Integer id, Pageable pageable) {
        return iBlogRepository.findByCategory_Id(id,pageable);
    }

    @Override
    public Page<Blog> searchNameAnhCategory(String searchName, Integer id, Pageable pageable) {
        return iBlogRepository.findByNameContainingAndCategory_Id(searchName,id,pageable);
    }
}
