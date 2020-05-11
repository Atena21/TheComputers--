package com.example.TheComputersmm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCommand {
	private Integer chatId;
	
	public SearchCommand(@JsonProperty("chatId") Integer chatId) {
		this.chatId = chatId;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}
	
}
