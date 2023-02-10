package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSer implements IProductSer {
    @Autowired
    IProductRepo iProductRepo;
    @Override
    public List<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        iProductRepo.update(id,product);
    }

    @Override
    public void remove(int id) {
        iProductRepo.remove(id);
    }

    @Override
    public List<Product> findByName(String nameCheck) {
        return iProductRepo.findByName(nameCheck);
    }
}
