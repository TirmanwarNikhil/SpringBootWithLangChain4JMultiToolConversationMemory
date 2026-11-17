package com.nikhil.lc4jmultitoolconversationmemory.service;

import org.springframework.stereotype.Service;

import com.nikhil.lc4jmultitoolconversationmemory.assistant.OrderAssistant;

@Service
public class OrderAssistantService {

    private final OrderAssistant assistant;

    public OrderAssistantService(OrderAssistant assistant) {
        this.assistant = assistant;
    }

    public String chat(String sessionId, String question) {
        return assistant.chat(sessionId, question);
    }
}