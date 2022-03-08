package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public Optional<BookDto> get(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toBookDto);
    }

    @Override
    public List<BookDto> getAllBookName() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> getByNameBook(String nameBook) {
        return bookRepository.findByNameBook(nameBook)
                .map(bookMapper::toBookDto);
    }

    @Override
    public BookDto createBook(BookDto bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
        return bookMapper.toBookDto(bookRepository.save(book));
    }
}
