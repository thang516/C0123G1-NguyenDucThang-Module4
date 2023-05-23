package com.example.product_manager.repository;

import com.example.product_manager.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Trà Chanh", 25, "Trà Chanh Rất Ngon ", "Goongcha"));
        productList.add(new Product(2, "Trà Sữa", 35, "Trà Sữa rất ngon ", "Goongcha"));
        productList.add(new Product(3, "Trà Gừng ", 20, "Trà Gừng Rất Ngon ", "Goongcha"));
        productList.add(new Product(4, "Trà Tắc", 34, "Trà Tắc  Rất Ngon ", "Goongcha"));
        productList.add(new Product(5, "Trà Sen", 25, "Trà Sen ", "Goongcha"));
        productList.add(new Product(6, "Trà Đá", 30, "Trà Đá rất ngon ", "Goongcha"));
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            if (id.equals(product.getId())) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())) {
                productList.set(i, product);
                break;

            }
        }
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id.equals(productList.get(i).getId())) {
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getName())) {
                products.add(productList.get(i));

            }
        }

        return products;
    }


}
