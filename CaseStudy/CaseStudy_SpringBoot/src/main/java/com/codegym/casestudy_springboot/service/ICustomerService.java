package com.codegym.casestudy_springboot.service;

import com.codegym.casestudy_springboot.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void deleteById(int id);

    Page<Customer> paqing(Pageable pageable);

//    Page<Customer> paginationByName(String name, Pageable pageable);

//    Page<Customer> paginationByIdCard(String idCard, Pageable pageable);
//
//    Page<Customer> paginationByCustomerType_Id(Integer id, Pageable pageable);
//
    Page<Customer> paginationByNameAndIdCard(String name,String idCard, Pageable pageable);
//    Page<Customer> paginationByNameAndCustomerType_Id(String name,Integer id, Pageable pageable);
//    Page<Customer> paginationByIdCardAndCustomerType_Id(String idCard,Integer id, Pageable pageable);
    Page<Customer> paginationByNameAndIdCardAndCustomerType_Id(String name,String idCard,Integer id, Pageable pageable);
}
