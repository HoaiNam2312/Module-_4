package com.codegym.libraryapp.service;

import com.codegym.libraryapp.model.Reader;

import java.util.List;

public interface IReaderService {
    List<Reader> findAll();

    void save(Reader reader);

    void deleteById(int id);

    Reader findByCodeBook(String code);
}
