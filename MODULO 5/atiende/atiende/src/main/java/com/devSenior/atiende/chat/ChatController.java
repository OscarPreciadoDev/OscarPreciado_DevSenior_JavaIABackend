package com.devSenior.atiende.chat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devSenior.atiende.chat.dto.ChatRequest;
import com.devSenior.atiende.chat.dto.ChatResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

	private final ChatbotService chatbotService;

	public ChatController(ChatbotService chatbotService) {
		this.chatbotService = chatbotService;
	}

	@PostMapping
	public ChatResponse responder(@Valid @RequestBody ChatRequest peticion) {
		return chatbotService.responder(peticion);
	}
}
