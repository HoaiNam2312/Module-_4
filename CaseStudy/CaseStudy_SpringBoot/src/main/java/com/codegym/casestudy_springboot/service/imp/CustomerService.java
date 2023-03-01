package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.repository.ICustomerRepository;
import com.codegym.casestudy_springboot.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }
}
