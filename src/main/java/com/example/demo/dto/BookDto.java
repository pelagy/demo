package com.example.demo.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String nameBook;
    private String author;
    private Double price;
}
