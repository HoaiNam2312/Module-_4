package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepo implements IProductRepo {
    private static final Map<Integer, Product> PRODUCT_MAP;
    static {
        PRODUCT_MAP = new HashMap<>();
        PRODUCT_MAP.put(1, new Product(1,"Iphone12",1000,"Black","Apple"));
        PRODUCT_MAP.put(2, new Product(2,"Iphone13",2000,"Black","Apple"));
        PRODUCT_MAP.put(3, new Product(3,"Iphone14",3000,"Black","Apple"));
        PRODUCT_MAP.put(4, new Product(4,"Iphone15",4000,"Black","Apple"));
        PRODUCT_MAP.put(5, new Product(5,"Iphone16",5000,"Black","Apple"));
        PRODUCT_MAP.put(6, new Product(6,"Iphone17",6000,"Black","Apple"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(PRODUCT_MAP.values());
    }

    @Override
    public void save(Product product) {
        PRODUCT_MAP.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return PRODUCT_MAP.get(id);
    }

    @Override
    public void update(int id, Product product) {
        PRODUCT_MAP.put(id, product);
    }

    @Override
    public void remove(int id) {
        PRODUCT_MAP.remove(id);
    }

    @Override
    public List<Product> findByName(String nameCheck) {
        List<Product> products = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : PRODUCT_MAP.entrySet()) {
            if (entry.getValue().getName().contains(nameCheck)) {
                products.add(entry.getValue());
            }
        }
        return products;
    }
}
