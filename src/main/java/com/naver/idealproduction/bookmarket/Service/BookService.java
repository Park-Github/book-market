package com.naver.idealproduction.bookmarket.Service;

import com.naver.idealproduction.bookmarket.Domain.Book;
import com.naver.idealproduction.bookmarket.Repos.MemoryBookRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final MemoryBookRepos memoryBookRepos;
    @Autowired
    public BookService(MemoryBookRepos memoryBookRepos) {
        this.memoryBookRepos = memoryBookRepos;
    }

    public void initBookDB(){
        memoryBookRepos.inputBookDB();
    }

    public List<Book> copyBookList() {
        return memoryBookRepos.memoryAccess_copyDB();
    }

    public Object searchBookById(String id) {
        Optional<Book> book = memoryBookRepos.memoryAccess_searchBookById(id);
        if(book.isPresent()){
            return book.get();
        }
        else {
            return new NullPointerException();
        }
    }

}

