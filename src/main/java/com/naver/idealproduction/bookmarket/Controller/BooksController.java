package com.naver.idealproduction.bookmarket.Controller;

import com.naver.idealproduction.bookmarket.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    @Autowired
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String responseBooksView(Model model) {
//        Book book = new Book();
        model.addAttribute("bookList", bookService.copyBookList());
//        book = (Book) model.getAttribute("book");
//        model.addAttribute("book.name", book.getName());
//        model.addAttribute("book.author", book.getAuthor());
//        model.addAttribute("book.publisher", book.getPublisher());
//        model.addAttribute("book.releaseDate", book.getReleaseDate());
//        model.addAttribute("book.description", book.getDescription());
//        model.addAttribute("book.price", book.getPrice());
//        model.addAttribute("id", book.getId());
        return "books";
    }

}
