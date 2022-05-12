package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String userName;
    @NotNull
    private String password;
    private String email;

}
