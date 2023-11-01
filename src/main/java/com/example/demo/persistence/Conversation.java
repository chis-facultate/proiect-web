package com.example.demo.persistence;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Conversation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "conversation_name")
    private String conversationName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConversationName() {
        return conversationName;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conversation that = (Conversation) o;
        return id == that.id && Objects.equals(conversationName, that.conversationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversationName);
    }
}
