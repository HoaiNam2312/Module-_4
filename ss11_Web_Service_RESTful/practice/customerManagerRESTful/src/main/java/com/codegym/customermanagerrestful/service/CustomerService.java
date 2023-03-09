package com.codegym.customermanagerrestful.service;

import com.codegym.customermanagerrestful.model.Customer;
import com.codegym.customermanagerrestful.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iProductRepository;

    @Override
    public List<Customer> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Customer  save(Customer customer) {
        return iProductRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
iProductRepository.deleteById(id);
    }

    @Override
    public Customer findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
