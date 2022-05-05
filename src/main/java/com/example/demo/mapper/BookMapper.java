package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface BookMapper {

    @Mapping(source = "nameBook", target = "nameBook", qualifiedByName = "name1Book")
    Book toBook(BookDto bookDTO);
    BookDto toBookDto(Book book);

    @Named("name1Book")
    default String getNameBook(String nameBook) {
        return nameBook;
    }
}
