package com.example.gio_hang.service;

import com.example.gio_hang.model.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {


    @Override
    public boolean checkExist(Shopping shopping1, Map<Shopping, Integer> cart) {
        for (Map.Entry<Shopping, Integer> x : cart.entrySet()) {
            if (x.getKey().getId().equals(shopping1.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Map.Entry<Shopping, Integer> shoppingEntry(Shopping shopping1, Map<Shopping, Integer> cart) {
        for (Map.Entry<Shopping,Integer> x : cart.entrySet()) {
            if(x.getKey().getId().equals(shopping1.getId())){
                return x;
            }
        }
        return null;
    }

    @Override
    public double getTotal(Map<Shopping, Integer> cart) {
        double sum = 0;
        for (Map.Entry<Shopping, Integer> e :
                cart.entrySet()) {
            sum = sum + e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }
}
