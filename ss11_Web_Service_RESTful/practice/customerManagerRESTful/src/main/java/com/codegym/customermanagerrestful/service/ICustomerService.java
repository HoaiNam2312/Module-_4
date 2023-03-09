package com.codegym.customermanagerrestful.service;

import com.codegym.customermanagerrestful.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer save(Customer customer);

    void deleteById(int id);

    Customer findById(int id);
}
