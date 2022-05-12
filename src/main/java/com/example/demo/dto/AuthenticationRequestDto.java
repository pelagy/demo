package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDto {
    private String userName;
    private String password;
}
