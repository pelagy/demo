package com.example.demo.service;

import com.example.demo.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookDto> get(Long id);

    List<BookDto> getAllBookName();

    Optional<BookDto> getByNameBook(String nameBook);

    BookDto createBook(BookDto bookDto);

}
