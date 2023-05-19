package com.example.caculator.controller;

import com.example.caculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorRepository {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @PostMapping("/")
    public String calculate(@RequestParam Double number1 , @RequestParam Double number2 , @RequestParam String calculator , Model model ){
        double result = calculatorService.calculate(number1,number2,calculator);
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        model.addAttribute("result",result);
        return "index";
    }

}
