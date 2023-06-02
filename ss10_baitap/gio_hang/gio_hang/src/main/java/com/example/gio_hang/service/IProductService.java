package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
