package com.example.ontap.service;

import com.example.ontap.model.Product;
import com.example.ontap.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository ;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll() ;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer deleteId) {
        productRepository.deleteById(deleteId);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public Page<Product> getAllPage(int page) {

        return productRepository.findAll(PageRequest.of(page,2, Sort.by("name"))) ;
    }

    @Override
    public Page<Product> search(String name, Pageable pageable) {
        return productRepository.search(name,pageable);
    }
}
