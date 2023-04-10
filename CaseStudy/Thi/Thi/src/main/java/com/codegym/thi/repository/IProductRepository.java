package com.codegym.thi.repository;

import com.codegym.thi.model.Motel;
import com.codegym.thi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);

    @Query(value = "select * from product where name like  %:name% and price like %:price% and product_type_id like %:productTypeId%", nativeQuery = true)
    Page<Product> search(@Param("name") String name,
                       @Param("price") String price,
                       @Param("productTypeId") String productTypeId,
                       org.springframework.data.domain.Pageable pageable);
}
