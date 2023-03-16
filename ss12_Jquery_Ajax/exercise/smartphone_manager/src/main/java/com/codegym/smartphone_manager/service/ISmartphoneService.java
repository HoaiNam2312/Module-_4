package com.codegym.smartphone_manager.service;

import com.codegym.smartphone_manager.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void deleteById(Long id);
}
