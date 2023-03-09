package com.codegym.customermanagerrestful.repository;

import com.codegym.customermanagerrestful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
