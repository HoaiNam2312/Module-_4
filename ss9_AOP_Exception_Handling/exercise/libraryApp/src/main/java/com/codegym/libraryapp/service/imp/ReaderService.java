package com.codegym.libraryapp.service.imp;

import com.codegym.libraryapp.model.Reader;
import com.codegym.libraryapp.repository.IReaderRepository;
import com.codegym.libraryapp.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReaderService implements IReaderService {

    @Autowired
    IReaderRepository iReaderRepository;

    @Override
    public List<Reader> findAll() {
        return iReaderRepository.findAll();
    }

    @Override
    public void save(Reader reader) {
        iReaderRepository.save(reader);
    }

    @Override
    public void deleteById(int id) {
        iReaderRepository.deleteById(id);
    }

    @Override
    public Reader findByCodeBook(String code) {
        return iReaderRepository.findByCodeBook(code);
    }
}
