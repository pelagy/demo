package com.example.demo.jwtsecurity;

import javax.naming.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException {


    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
