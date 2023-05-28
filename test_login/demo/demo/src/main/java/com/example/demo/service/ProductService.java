package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findAll(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> search(String name, Pageable pageAble) {
        Page<Product> productList = productRepository.search(name, pageAble);
        return productList;
    }

    @Override
    public Page<Product> getAllPage(int page) {


        return productRepository.findAll(PageRequest.of(page, 3, Sort.by("name")));
    }
}
