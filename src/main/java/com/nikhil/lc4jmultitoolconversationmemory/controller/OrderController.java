package com.nikhil.lc4jmultitoolconversationmemory.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.lc4jmultitoolconversationmemory.dto.ChatRequest;
import com.nikhil.lc4jmultitoolconversationmemory.dto.ChatResponse;
import com.nikhil.lc4jmultitoolconversationmemory.service.OrderAssistantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/assistant")
@Tag(name = "AI Conversation Assistant")
public class OrderController {

	private final OrderAssistantService assistantService;

	public OrderController(OrderAssistantService assistantService) {
		this.assistantService = assistantService;
	}

	@PostMapping("/chat")
	@Operation(summary = "Chat with AI assistant", description = "Maintains conversation context using sessionId")
	public ChatResponse chat(@Valid @RequestBody ChatRequest request) {

		String answer = assistantService.chat(request.sessionId(), request.question());

		return new ChatResponse(request.sessionId(), answer);
	}
}
