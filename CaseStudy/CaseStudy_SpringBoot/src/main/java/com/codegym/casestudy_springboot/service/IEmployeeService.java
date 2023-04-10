package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.customer.Customer;
import com.codegym.casestudy_springboot.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);

    Page<Employee> paging(Pageable pageable);

    Page<Employee> search(String idCard, String divisionId, String positionId, String educationDegree, Pageable pageable);
//    Page<Employee> search(String idCard, Pageable pageable);
}
