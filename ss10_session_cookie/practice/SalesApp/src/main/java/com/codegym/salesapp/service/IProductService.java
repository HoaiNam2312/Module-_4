package com.codegym.salesapp.service;

import com.codegym.salesapp.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
