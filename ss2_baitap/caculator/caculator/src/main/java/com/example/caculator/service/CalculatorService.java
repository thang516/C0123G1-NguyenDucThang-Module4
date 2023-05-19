package com.example.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(Double number1, Double number2, String calculator) {
        double result = 0;
        switch (calculator){
            case "Addition(+)":
              result =  number1 + number2 ;
                break;
            case "Subtraction(-)":
                result= number1 - number2 ;
                break;

            case "Multiplication(x)":
                result = number1 * number2 ;
                break;

            case "Division(/)":
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
