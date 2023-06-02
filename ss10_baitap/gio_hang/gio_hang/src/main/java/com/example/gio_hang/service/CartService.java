package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {


    @Override
    public boolean checkExist(Product product1, Map<Product, Integer> cart) {
        for (Map.Entry<Product, Integer> x : cart.entrySet()) {
            if (x.getKey().getId().equals(product1.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map.Entry<Product, Integer> shoppingEntry(Product product1, Map<Product, Integer> cart) {
        for (Map.Entry<Product,Integer> x : cart.entrySet()) {
            if(x.getKey().getId().equals(product1.getId())){
                return x;
            }
        }
        return null;
    }

    @Override
    public double getTotal(Map<Product, Integer> cart) {
        double sum = 0;
        for (Map.Entry<Product, Integer> e :
                cart.entrySet()) {
            sum = sum + e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }
}
