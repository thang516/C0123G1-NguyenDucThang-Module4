package com.example.bai1.controller;

import com.example.bai1.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    private ICurrencyConversionService currencyConversionService ;

    @GetMapping("/")
    public String currencyConversion (){
        return "form";
    }

    @PostMapping("/")
    public String calculation (Model model , @RequestParam(value = "dollarAmount")int dollarAmount ,@RequestParam(value = "exchangeRate")int exchangeRate){
        int result = currencyConversionService.calculation(exchangeRate,dollarAmount);
        model.addAttribute("result",result);
        return "form";

    }




}
