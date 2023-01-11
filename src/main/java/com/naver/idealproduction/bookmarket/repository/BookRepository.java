package com.naver.idealproduction.bookmarket.repository;

import com.naver.idealproduction.bookmarket.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookRepository {

    List<Book> getAll();

    Optional<Book> getOne(String id);

    List<Book> getByCategory(String category);

    List<Book> getByFilter(Map<String, List<String>> filter);

}
