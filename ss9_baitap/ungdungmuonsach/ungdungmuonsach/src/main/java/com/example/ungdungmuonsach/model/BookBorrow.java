package com.example.ungdungmuonsach.model;


import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "status=false")
@SQLDelete(sql = "UPDATE book_borrow SET status = true WHERE id=?")

public class BookBorrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private Integer code;

    @ManyToOne
    @JoinColumn
    private Book book;


    private boolean status = false;


    public BookBorrow() {
    }

    public BookBorrow(Integer id, Integer code, Book book) {
        this.id = id;
        this.code = code;
        this.book = book;
    }

    public BookBorrow(Integer code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


}
