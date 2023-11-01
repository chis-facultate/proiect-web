package com.example.demo.service;

import com.example.demo.persistence.Conversation;
import com.example.demo.repository.ConversationRepository;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class ConversationService {

    ConversationRepository conversationRepository;

    public ConversationService(ConversationRepository conversationRepository){
        this.conversationRepository = conversationRepository;
    }



    public List<Conversation> getAllConversations(){
        return conversationRepository.findAll();
    }


}
