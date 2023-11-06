package com.example.demo.controller;

import com.example.demo.model.ConversationDTO;
import com.example.demo.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping(value="/conversations")
    public ResponseEntity<Object> getAllConversations(){
        return new ResponseEntity<>(conversationService.getAllConversations(),
                HttpStatus.OK);
    }

}
