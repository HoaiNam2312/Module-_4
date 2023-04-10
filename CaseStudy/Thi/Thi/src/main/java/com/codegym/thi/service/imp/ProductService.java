package com.codegym.thi.service.imp;

import com.codegym.thi.model.Product;
import com.codegym.thi.repository.IProductRepository;
import com.codegym.thi.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> paqing(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> search(String name, String price, String productTypeId, Pageable pageable) {
        return iProductRepository.search(name,price,productTypeId,pageable);
    }
}
