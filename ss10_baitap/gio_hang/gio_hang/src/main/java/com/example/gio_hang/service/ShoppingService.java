package com.example.gio_hang.service;

import com.example.gio_hang.model.Shopping;
import com.example.gio_hang.repository.IShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService implements IShoppingService {
    @Autowired
    private IShoppingRepository shoppingRepository;


    @Override
    public List<Shopping> findAll() {
        return shoppingRepository.findAll();
    }

    @Override
    public Shopping findById(Integer id) {
        return shoppingRepository.findById(id).get();
    }
}
