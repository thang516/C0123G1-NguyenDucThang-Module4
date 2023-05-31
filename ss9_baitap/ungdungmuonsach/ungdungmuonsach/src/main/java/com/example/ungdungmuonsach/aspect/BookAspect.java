package com.example.ungdungmuonsach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Aspect
@Component
public class BookAspect {
    private static int count = 0;

    @After("execution(* com.example.ungdungmuonsach.controller.BookBorrowController.*(..))")
    public void log(JoinPoint joinPoint) throws IOException {

        File file = new File("D:\\codegym\\C0123G1-NguyenDucThang-Module4\\ss9_baitap\\ungdungmuonsach\\ungdungmuonsach\\src\\main\\java\\com\\example\\ungdungmuonsach\\log\\book.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning(value = "execution(* com.example.ungdungmuonsach.controller.BookBorrowController.*(..))", returning = "result")
    public void logBorrow(JoinPoint joinPoint, Object result) {
        File file = new File("D:\\codegym\\C0123G1-NguyenDucThang-Module4\\ss9_baitap\\ungdungmuonsach\\ungdungmuonsach\\src\\main\\java\\com\\example\\ungdungmuonsach\\log\\visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(joinPoint.getSignature().getName());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @After(value = "execution(* com.example.ungdungmuonsach.controller.BookBorrowController.*(..))")
    public void logUserVisit(JoinPoint joinPoint) {
        File file = new File("D:\\codegym\\C0123G1-NguyenDucThang-Module4\\ss9_baitap\\ungdungmuonsach\\ungdungmuonsach\\src\\main\\java\\com\\example\\ungdungmuonsach\\log\\visit.csv");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        count++;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(count);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
