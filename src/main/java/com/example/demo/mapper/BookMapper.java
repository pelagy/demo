package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BookMapper {

    @Mapping(target = "nameBook", expression = "java(bookDTO.getNameBook() + bookDTO.getAuthor() + bookDTO.getPrice())")
    Book toBook(BookDto bookDTO);
    BookDto toBookDto(Book book);
}
