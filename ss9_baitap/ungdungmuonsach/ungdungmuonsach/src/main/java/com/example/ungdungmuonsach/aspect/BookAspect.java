package com.example.ungdungmuonsach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;

@Aspect
@Component
public class BookAspect {
    @After("execution(* com.example.ungdungmuonsach.controller.BookBorrowController.*(..))")
    public void log(JoinPoint joinPoint){
          
    }
}
