package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContainingAndIdCardContaining(String name, String idCard, Pageable pageable);

    Page<Customer> findByNameContainingAndIdCardContainingAndCustomerType_Id(String name, String idCard, Integer id, Pageable pageable);
}
