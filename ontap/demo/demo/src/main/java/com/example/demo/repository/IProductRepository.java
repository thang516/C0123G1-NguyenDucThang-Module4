package com.example.demo.repository;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void save(Product product);

    void delete(Integer id);

    Product findById(Integer id );

    void update(Integer id , Product product);
}
