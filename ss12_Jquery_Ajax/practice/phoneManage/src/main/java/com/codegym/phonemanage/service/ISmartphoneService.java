package com.codegym.phonemanage.service;

import com.codegym.phonemanage.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void deleteById(Long id);
}
