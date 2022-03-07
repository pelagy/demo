package com.example.demo.repository;

import com.example.demo.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findBookByNameBook(String nameBook);

    Book getBookById(Long id);
}
