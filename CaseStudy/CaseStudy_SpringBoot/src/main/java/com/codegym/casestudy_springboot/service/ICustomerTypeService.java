package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
