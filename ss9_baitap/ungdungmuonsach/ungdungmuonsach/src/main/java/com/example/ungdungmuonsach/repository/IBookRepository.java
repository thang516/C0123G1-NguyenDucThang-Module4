package com.example.ungdungmuonsach.repository;

import com.example.ungdungmuonsach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book , Integer> {
}
