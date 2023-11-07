package com.example.demo.controller;

import com.example.demo.model.ConversationUserDTO;
import com.example.demo.service.ConversationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversation_user")
public class ConversationUserController {

    @Autowired
    private ConversationUserService conversationUserService;

    @PostMapping(value = "/invite")
    public ResponseEntity<Object> invite(@RequestBody ConversationUserDTO conversationUserDTO) {
        return new ResponseEntity<>(conversationUserService.inviteToConversation(conversationUserDTO),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/leave/{conversationId}/{userId}")
    public ResponseEntity<Object> leave(@PathVariable Long conversationId, @PathVariable Long userId){
        conversationUserService.deleteByConversationIdAndUserId(conversationId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
