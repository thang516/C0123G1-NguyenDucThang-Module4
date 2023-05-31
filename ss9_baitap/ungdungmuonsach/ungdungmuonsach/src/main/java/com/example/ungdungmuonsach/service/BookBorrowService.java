package com.example.ungdungmuonsach.service;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.model.BookBorrow;
import com.example.ungdungmuonsach.repository.IBookBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowService implements IBookBorrowService {
    @Autowired
    private IBookBorrowRepository bookBorrowRepository ;
    @Override
    public boolean save(BookBorrow bookBorrow) {

        int checkQuantity = bookBorrow.getBook().getQuantity();
        if(checkQuantity < 0 ){
            return false;
        }

        bookBorrowRepository.save(bookBorrow);
        return true;
    }

    @Override
    public BookBorrow findById(Integer id) {
        return bookBorrowRepository.findById(id).get();
    }

    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        bookBorrowRepository.deleteById(id);
    }


}
