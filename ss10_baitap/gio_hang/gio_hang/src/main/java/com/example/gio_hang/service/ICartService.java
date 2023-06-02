package com.example.gio_hang.service;

import com.example.gio_hang.model.Product;

import java.util.Map;

public interface ICartService {
    boolean checkExist(Product product, Map<Product, Integer> cart);

    Map.Entry<Product, Integer> shoppingEntry(Product product, Map<Product, Integer> cart);
    double getTotal(Map<Product, Integer> cart) ;
}
