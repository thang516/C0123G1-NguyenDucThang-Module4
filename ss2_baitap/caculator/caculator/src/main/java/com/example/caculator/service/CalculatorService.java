package com.example.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(Double number1, Double number2, String calculator) {
        double result = 0;
        switch (calculator){
            case "addition":
              result =  number1 + number2 ;
                break;
            case "subtraction":
                result= number1 - number2 ;
                break;

            case "multiplication":
                result = number1 * number2 ;
                break;

            case "division":
                try {
                    result= number1/number2;
                }
                catch (ArithmeticException e){
                    e.printStackTrace();
                }
                break;

        }
        return result ;
    }
}
