package com.example.gio_hang.service;

import com.example.gio_hang.model.Shopping;

import java.util.Map;

public interface ICartService {
    boolean checkExist(Shopping shopping1, Map<Shopping, Integer> cart);

    Map.Entry<Shopping, Integer> shoppingEntry(Shopping shopping1, Map<Shopping, Integer> cart);
    double getTotal(Map<Shopping, Integer> cart) ;
}
