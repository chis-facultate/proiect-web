package com.example.demo.controller;

import com.example.demo.service.ConversationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conversation_user")
public class ConversationUserController {

    @Autowired
    private ConversationUserService conversationUserService;

    @DeleteMapping(value = "/leave/{conversationId}/{userId}")
    public ResponseEntity<Object> leave(@PathVariable Long conversationId, @PathVariable Long userId){
        conversationUserService.deleteByConversationIdAndUserId(conversationId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
