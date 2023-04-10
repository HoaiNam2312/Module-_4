package com.codegym.thi.repository;

import com.codegym.thi.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType,Integer> {

}
