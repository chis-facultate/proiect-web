package com.example.demo.controller;

import com.example.demo.model.UserCredentialsDTO;
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

    /**
     * Authentication authenticate = authenticationManager.authenticate(...)
     * It attempts to authenticate the user by using the authenticationManager.
     * It creates an Authentication object with the provided UsernamePasswordAuthenticationToken,
     * which contains the user's login credentials.
     *
     * SecurityContextHolder.getContext().setAuthentication(authenticate)
     * After successful authentication, the authenticated Authentication object is set in the security context.
     * This step effectively logs the user in.
     *
     * @param userCredentialsDTO obiect de transfer continand credentialele care trebuie verificate
     * @return HTTP STATUS CREATED
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userCredentialsDTO.getLoginUsername(),
                        userCredentialsDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new ResponseEntity<>("Login successfully!", HttpStatus.CREATED);
    }
}