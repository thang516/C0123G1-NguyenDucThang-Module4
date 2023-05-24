package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> getAll() {
        List<Product> productList = BaseRepository.entityManager.createQuery("select p  from Product p ", Product.class).getResultList();
        return productList;
    }

    @Override
    public void save(Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.persist(product);
        transaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        Product product = BaseRepository.entityManager.find(Product.class, id);
        return product;
    }

    @Override
    public void update(Integer id, Product product) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.merge(product);
        transaction.commit();
    }

    @Override
    public void delete(Integer id) {
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        BaseRepository.entityManager.remove(findById(id));
        transaction.commit();
    }

    @Override

    public List<Product> search(String name) {

        List<Product> productList = BaseRepository.entityManager.createQuery("SELECT p FROM Product p where p.name LIKE :name  ", Product.class).setParameter("name", '%' + name + '%').getResultList();
        return productList;
    }

}
