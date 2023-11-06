package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Object> getUserData(@PathVariable Long id){
        return new ResponseEntity<>(userService.findById(id),
                HttpStatus.OK);
    }

    @PatchMapping(value = "/patch_nickname/{id}/{newNickname}")
    public ResponseEntity<Object> patchNickname(@PathVariable Long id, @PathVariable String newNickname){
        return new ResponseEntity<>(userService.patchNickname(id, newNickname),
                HttpStatus.OK);
    }
}
