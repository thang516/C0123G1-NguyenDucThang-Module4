package com.example.bai1.service;

import org.springframework.beans.factory.annotation.Autowired;

public interface ICurrencyConversionService {

    int calculate(int exchangeRate, int dollarAmount);
}
