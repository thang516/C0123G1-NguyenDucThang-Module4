package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow, Integer> {
}
