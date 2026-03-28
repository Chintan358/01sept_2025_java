package com.eshop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.config.AuthRequest;
import com.eshop.demo.config.JwtUtill;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtill jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {

    	
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getName());
    }
}