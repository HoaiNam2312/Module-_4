package com.codegym.casestudy_springboot.repository;

import com.codegym.casestudy_springboot.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContainingAndIdCardContaining(String name, String idCard, Pageable pageable);

    Page<Customer> findByNameContainingAndIdCardContainingAndCustomerType_Id(String name, String idCard, Integer id, Pageable pageable);

    @Query(value = "select * from customer where name like :name and id_card like :idCard and customer_type_id like :customerTypeId",nativeQuery = true)
    Page<Customer> search(@Param("name") String name,
                          @Param("idCard") String idCard,
                          @Param("customerTypeId") String customerTypeId,
                          Pageable pageable);
}
