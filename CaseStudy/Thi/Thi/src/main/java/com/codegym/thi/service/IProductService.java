package com.codegym.thi.service;

import com.codegym.thi.model.Motel;
import com.codegym.thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void deleteById(int id);

    Page<Product> paqing(Pageable pageable);

    Page<Product> search(String name, String price,String productTypeId, Pageable pageable);
}
