package com.codegym.libraryapp.service;

import com.codegym.libraryapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void deleteByid(int id);
}
