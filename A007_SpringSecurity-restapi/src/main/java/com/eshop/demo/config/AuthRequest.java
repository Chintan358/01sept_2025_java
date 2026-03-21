package com.eshop.demo.config;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}