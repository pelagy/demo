package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    public final PasswordEncoder passwordEncoder;


    @Override
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserName(userDto.getUserName());
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }

    @Override
    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
