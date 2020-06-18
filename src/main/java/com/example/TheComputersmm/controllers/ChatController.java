package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.dto.ChatInfoCommand;
import com.example.TheComputersmm.dto.MessageCommand;
import com.example.TheComputersmm.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController {
	
	private ChatService chatService;
	
	@Autowired
	public ChatController(ChatService chatService) 	{
		this.chatService = chatService;
	}
	
	@RequestMapping(value = "/chatInfo", method = RequestMethod.POST)
	public ChatInfoCommand getChatInfo() {
		return chatService.getChatInfo();
	}
	
	@RequestMapping(value="/messages", method = RequestMethod.GET)
	public List<MessageCommand> retrieveChatMessages() {
		return chatService.retrieveChatMessages();
	}

}
