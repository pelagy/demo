package com.example.demo.controllers;

import com.example.demo.dto.BookDto;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> books = bookService.getAllBookName();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    ResponseEntity<BookDto> getNameBook(@PathVariable String name){
        return bookService.getByNameBook(name)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping
    ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDTO){
    return new ResponseEntity<>(bookService.createBook(bookDTO), HttpStatus.OK);
    }
}
