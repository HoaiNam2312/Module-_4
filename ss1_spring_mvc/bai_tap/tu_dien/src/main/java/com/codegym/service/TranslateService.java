package com.codegym.service;

import com.codegym.repository.ITranslateRepository;
import com.codegym.repository.TranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    ITranslateRepository iTranslateRepository;
    @Override
    public String result(String key) {
        return iTranslateRepository.result(key);
    }
}
