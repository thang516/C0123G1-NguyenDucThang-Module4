package com.example.product_manager.service;

import com.example.product_manager.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);


    Product findById(Integer id);

    void update(Integer id, Product product);

    void delete(Integer id);

    List<Product> search(String name);
}
