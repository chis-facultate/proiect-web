package com.example.demo.service;

import com.example.demo.repository.ConversationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ConversationUserService {

    @Autowired
    private ConversationUserRepository conversationUserRepository;
    public void deleteByConversationIdAndUserId(Long conversationId, Long userId){
        conversationUserRepository.deleteByConversationIdAndUserId(conversationId, userId);
    }
}
