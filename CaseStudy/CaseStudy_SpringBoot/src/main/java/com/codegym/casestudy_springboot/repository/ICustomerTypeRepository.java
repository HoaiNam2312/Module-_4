package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
