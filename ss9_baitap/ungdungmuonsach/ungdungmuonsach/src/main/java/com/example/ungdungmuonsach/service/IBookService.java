package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.Book;

import java.util.List;

public interface IBookService {
    void save(Book book1);

    List<Book> findAll();

    Book findById(Integer id);
}
