package com.example.product_manager.service;

import com.example.product_manager.model.Product;
import com.example.product_manager.repository.IProductRepository;
import com.example.product_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.getAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }

}
