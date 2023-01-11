package com.naver.idealproduction.bookmarket.controller;

import com.naver.idealproduction.bookmarket.domain.Book;
import com.naver.idealproduction.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService service;

    @Autowired
    public BooksController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public String getBooks(Model model) {
        List<Book> list = service.getAllBooks();
        model.addAttribute("bookList", list);
        return "books";
    }

    @GetMapping("/{category}")
    public String getBooksByCategory(@PathVariable("category") String category, Model model) {
        List<Book> list = service.getBooks(category);
        model.addAttribute("bookList", list);
        return "books";
    }

    @GetMapping("/filter")
    public String getBooksByFilter(
            @MatrixVariable Map<String, List<String>> filter,
            Model model
    ) {
        List<Book> list = service.getBooks(filter);
        model.addAttribute("bookList", list);
        return "books";
    }

}
