package com.example.demo.controller;

import com.example.demo.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversations")
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @GetMapping(value="/get/{userId}")
    public ResponseEntity<Object> getConversationsOfUser(@PathVariable Long userId){
        return new ResponseEntity<>(conversationService.getConversationsOfUser(userId),
                HttpStatus.OK);
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> deleteConversation(@PathVariable Long id){
        conversationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
