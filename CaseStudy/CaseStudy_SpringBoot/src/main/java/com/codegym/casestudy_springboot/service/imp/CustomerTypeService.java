package com.codegym.casestudy_springboot.service.imp;

import com.codegym.casestudy_springboot.model.customer.CustomerType;
import com.codegym.casestudy_springboot.repository.ICustomerTypeRepository;
import com.codegym.casestudy_springboot.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
