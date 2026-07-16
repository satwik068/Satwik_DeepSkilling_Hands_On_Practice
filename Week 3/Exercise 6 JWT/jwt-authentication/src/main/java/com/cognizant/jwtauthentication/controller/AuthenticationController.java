package com.cognizant.jwtauthentication.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwtauthentication.model.AuthenticationResponse;
import com.cognizant.jwtauthentication.util.JwtUtil;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(Principal principal) {

        JwtUtil jwtUtil = new JwtUtil();

        String token = jwtUtil.generateToken(principal.getName());

        return new AuthenticationResponse(token);
    }
}