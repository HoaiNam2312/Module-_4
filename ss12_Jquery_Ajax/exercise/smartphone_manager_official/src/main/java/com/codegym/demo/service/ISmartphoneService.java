package com.codegym.demo.service;

import com.codegym.demo.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void deleteById(Long id);
}
