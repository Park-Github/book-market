package com.naver.idealproduction.bookmarket.Controller;

import com.naver.idealproduction.bookmarket.Domain.Book;
import com.naver.idealproduction.bookmarket.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public String responseBookView(@RequestParam(value = "id") String id, Model model) {
        Book book = (Book) bookService.searchBookById(id);
        model.addAttribute("book", book);
        return "book";
    }

}
