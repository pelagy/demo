package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import com.example.demo.mail.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final EmailService emailService;



    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUserName();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        emailService.sendSimpleMessage(userDto.getEmail());
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }

}
