package com.example.demo.controller;

import com.example.demo.model.UserCredentialsDTO;
import com.example.demo.persistence.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    private AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userCredentialsDTO.getLoginUsername(),
                        userCredentialsDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("Login successfully!", HttpStatus.OK);
    }

    /*
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody User userCredentialsDTO) {
    Authentication authenticate = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(userCredentialsDTO.getLoginUsername(),
                    userCredentialsDTO.getPasswordHash()));
    SecurityContextHolder.getContext().setAuthentication(authenticate);
    return new ResponseEntity<>("Login successfully!", HttpStatus.OK);
}
     */
}