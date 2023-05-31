package com.example.ungdungmuonsach.controller;

import com.example.ungdungmuonsach.model.Book;
import com.example.ungdungmuonsach.model.BookBorrow;
import com.example.ungdungmuonsach.service.IBookBorrowService;
import com.example.ungdungmuonsach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")

public class BookBorrowController {

    @Autowired
    private IBookBorrowService bookBorrowService;

    @Autowired
    private IBookService bookService;


    @GetMapping("")
    public String index(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "/index";
    }

    @GetMapping("/{id}/create")
    public String create(@PathVariable("id") Integer id, Model model) {
        Book book1 = bookService.findById(id);
        bookService.save(book1);
        book1.setQuantity(book1.getQuantity() - 1);
        Integer code = getRandom(10000, 999999);
        BookBorrow bookBorrow = new BookBorrow(code, book1);
        model.addAttribute("book", bookBorrow.getCode());
        boolean flag;
        int borrow;
        List<BookBorrow> numbers = bookBorrowService.findAll();
        do {
            flag = true;
            borrow = getRandom(10000, 999999);
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i).getCode() == borrow) {
                    flag = false;
                }
            }
        } while (!flag);

        boolean check = bookBorrowService.save(bookBorrow);

        if (!check) {
            return "/error";
        }
        return "/result";
    }

    @GetMapping("/borrow")
    public String select(Model model) {
        List<BookBorrow> bookBorrowList = bookBorrowService.findAll();
        model.addAttribute("bookBorrowList", bookBorrowList);
        return "/home";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        BookBorrow bookBorrow = bookBorrowService.findById(id);
        Book book = bookBorrow.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookBorrowService.delete(id);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("mess", "You have returned the book");
        return "redirect:/book";
    }

    public int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @ExceptionHandler(Exception.class)
    public String handler() {

        return "error";
    }

}
