package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    void delete(Integer id);

    Product findById(Integer id);


    void update(Integer id, Product product);
}
