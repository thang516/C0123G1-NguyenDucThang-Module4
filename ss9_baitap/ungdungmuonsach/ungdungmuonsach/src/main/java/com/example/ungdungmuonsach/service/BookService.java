package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public void save(Book book1) {
        bookRepository.save(book1);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).get();
    }
}
