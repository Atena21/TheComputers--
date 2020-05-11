package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.dto.ChatListCommand;
import com.example.TheComputersmm.dto.ChatSelectionCommand;
import com.example.TheComputersmm.services.ChatSelectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatSelectorController {

	private ChatSelectorService chatSelectorService;
	
	@Autowired
	public ChatSelectorController(ChatSelectorService chatSelectorService) {
		this.chatSelectorService = chatSelectorService;
	}
	
	@RequestMapping(value = "/chats", method = RequestMethod.GET)
	public List<ChatListCommand> chats() {
		return this.chatSelectorService.chats();
	}

	@RequestMapping(value = "/selectChat", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String selectChat(@RequestBody ChatSelectionCommand chatSelectionCommand) {
		return String.valueOf(chatSelectorService.selectChat(chatSelectionCommand));
	}
	
}
