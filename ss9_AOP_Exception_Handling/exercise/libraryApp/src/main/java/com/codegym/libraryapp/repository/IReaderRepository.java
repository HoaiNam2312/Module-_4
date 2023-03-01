package com.codegym.libraryapp.repository;

import com.codegym.libraryapp.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReaderRepository extends JpaRepository<Reader, Integer> {
    Reader findByCodeBook(String code);
}
