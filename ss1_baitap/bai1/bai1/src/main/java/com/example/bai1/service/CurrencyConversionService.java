package com.example.bai1.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService{

    public int calculate(int exchangeRate, int dollarAmount) {
       return     exchangeRate*dollarAmount ;
    }
}
