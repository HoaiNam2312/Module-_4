package com.codegym.libraryapp.service.imp;

import com.codegym.libraryapp.model.Book;
import com.codegym.libraryapp.repository.IBookRepository;
import com.codegym.libraryapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteByid(int id) {
        iBookRepository.deleteById(id);
    }
}
