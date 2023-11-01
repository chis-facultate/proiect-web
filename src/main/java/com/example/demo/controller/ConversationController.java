package com.example.demo.controller;

import com.example.demo.model.ConversationDTO;
import com.example.demo.service.ConversationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class ConversationController {
    ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping(value="/conversations")
    public ResponseEntity<Object> getAllConversations(){
        return new ResponseEntity<>(conversationService.getAllConversations().stream()
                .map(o -> new ConversationDTO(o.getId(), o.getConversationName()))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

}
