package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBookName();
        if (books == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    ResponseEntity<Book> getId(@PathVariable(name = "id") long id) {
//        Book book = bookService.get(id);
//        if (book == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }

    @GetMapping("/{name}")
    ResponseEntity<Book> getNameBook(@PathVariable(name = "name") String nameBook){
        Book book = bookService.getByNameBook(nameBook);
        if(book == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
