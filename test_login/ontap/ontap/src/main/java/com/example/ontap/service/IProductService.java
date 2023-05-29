package com.example.ontap.service;


import com.example.ontap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {


    List<Product> getAll();

    void save(Product product);

    void delete(Integer deleteId);

    Product findById(Integer id);

    void update(Product product);

    Page<Product> getAllPage(int page);

    Page<Product> search(String name, Pageable pageable);
}
