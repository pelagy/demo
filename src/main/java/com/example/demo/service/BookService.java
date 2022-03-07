package com.example.demo.service;

import com.example.demo.models.Book;

import java.util.List;

public interface BookService {
    Book get(Long id);

    List<Book> getAllBookName();

    Book getByNameBook(String nameBook);

}
