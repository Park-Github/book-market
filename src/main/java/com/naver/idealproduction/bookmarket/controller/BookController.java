package com.naver.idealproduction.bookmarket.controller;

import com.naver.idealproduction.bookmarket.domain.Book;
import com.naver.idealproduction.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/book")
    public String getBookByID(@RequestParam String id, Model model) {
        Optional<Book> book = service.getBook(id);

        if (book.isEmpty()) {
            throw new ErrorResponseException(HttpStatus.NOT_FOUND);
        }

        model.addAttribute("book", book.get());
        return "book";
    }

}
