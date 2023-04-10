package com.codegym.thi.service;

import com.codegym.thi.model.Payment;
import com.codegym.thi.model.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> findAll();
}
