package com.example.ontap.repository;

import com.example.ontap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IProductRepository extends JpaRepository<Product,Integer> {


    @Query(value = "SELECT s FROM Product  s WHERE s.name LIKE :name")
    Page<Product> search(String name, Pageable pageable);
}
