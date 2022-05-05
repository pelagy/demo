package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper
public abstract class UserMapper {
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mappings({
            @Mapping(target = "active", constant = "true"),
            @Mapping(
                    target = "password",
                    expression = "java(passwordEncoder.encode(user.getPassword()))"),
            @Mapping(
                    target = "roles",
                    expression = "java(java.util.Collections.singleton(com.example.demo.models.Role.USER))")
    })

    public abstract User toUser(UserDto userDto);

    public abstract UserDto toUserDto(User user);
}
