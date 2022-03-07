package com.example.demo.service;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book get(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public List<Book> getAllBookName() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getByNameBook(String nameBook) {
        return bookRepository.findBookByNameBook(nameBook);
    }
}
