package com.example.demo.service;

import com.example.demo.model.ConversationDTO;
import com.example.demo.persistence.Conversation;
import com.example.demo.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversationService {

    @Autowired
    private ConversationRepository conversationRepository;
    public List<ConversationDTO> getAllConversations(){
        return conversationRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public List<ConversationDTO> getConversationsOfUser(Long userId){
        return conversationRepository.findByUserId(userId)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id){
        conversationRepository.deleteById(id);
    }

    private ConversationDTO convertEntityToDto(Conversation conversation){
        return new ConversationDTO(conversation.getId(), conversation.getConversationName());
    }
}
