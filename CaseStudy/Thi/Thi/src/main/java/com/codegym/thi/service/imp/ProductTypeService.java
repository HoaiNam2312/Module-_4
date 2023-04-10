package com.codegym.thi.service.imp;

import com.codegym.thi.model.ProductType;
import com.codegym.thi.repository.IProductRepository;
import com.codegym.thi.repository.IProductTypeRepository;
import com.codegym.thi.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService implements IProductTypeService {
    @Autowired
    IProductTypeRepository iProductTypeRepository;

    @Override
    public List<ProductType> findAll() {
        return iProductTypeRepository.findAll();
    }
}
