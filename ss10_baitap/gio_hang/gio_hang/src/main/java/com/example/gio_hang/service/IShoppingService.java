package com.example.gio_hang.service;

import com.example.gio_hang.model.Shopping;

import java.util.List;

public interface IShoppingService {
    List<Shopping> findAll();

    Shopping findById(Integer id);
}
