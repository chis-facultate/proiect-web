package com.example.demo.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * This method configures the message broker.
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * registry.enableSimpleBroker("/topic") line enables a simple in-memory message broker
         * that can handle message destinations starting with "/topic".
         * Clients can subscribe to or send messages to these destinations.
         */
        registry.enableSimpleBroker("/topic");
    }

    /**
     * This method registers the STOMP (Simple Text Oriented Messaging Protocol) endpoint,
     * which is the entry point for WebSocket connections.
     * The endpoint is "/chat", and .withSockJS() indicates that SockJS should be used as a fallback
     * for clients that do not support WebSocket.
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
    }
}