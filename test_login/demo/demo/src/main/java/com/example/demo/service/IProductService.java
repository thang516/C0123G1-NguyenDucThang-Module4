package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    void delete(Integer id);

    Product findAll(Integer id);

    void update(Product product);

    Page<Product> search(String name, Pageable pageAble);

    Page<Product> getAllPage(int page);
}
