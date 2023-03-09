package com.codegym.salesapp.repository;

import com.codegym.salesapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
