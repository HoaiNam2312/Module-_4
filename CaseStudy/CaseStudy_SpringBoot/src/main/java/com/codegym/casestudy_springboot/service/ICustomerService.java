package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
    Page<Customer> search(Pageable pageable);
}
