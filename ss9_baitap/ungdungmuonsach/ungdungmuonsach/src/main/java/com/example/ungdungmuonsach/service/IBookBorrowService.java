package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.model.BookBorrow;

import java.util.List;

public interface IBookBorrowService {

    boolean save(BookBorrow bookBorrow);

    BookBorrow findById(Integer id);

    List<BookBorrow> findAll();

    void delete(Integer id);
}
