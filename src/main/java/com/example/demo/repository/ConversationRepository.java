package com.example.demo.repository;

import com.example.demo.persistence.Conversation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
    List<Conversation> findAll();
}
