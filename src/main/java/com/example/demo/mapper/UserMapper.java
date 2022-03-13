package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.UserDto;
import com.example.demo.models.Book;
import com.example.demo.models.User;
import org.mapstruct.Mapping;

public interface UserMapper {

    @Mapping(target = "name", expression = "java(userDto.getUserName())")
    User toUser(UserDto userDto);
    UserDto toUserDto(User user);
}
