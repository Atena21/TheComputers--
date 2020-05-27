package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.dto.GetUserRoomsCommand;
import com.example.TheComputersmm.dto.SearchCommand;
import com.example.TheComputersmm.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

	private SearchService searchService;
	
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@RequestMapping(value = "/chatss", method = RequestMethod.GET)
	public List<GetUserRoomsCommand> chats() {
		return this.searchService.chats();
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String selectChat(@RequestBody SearchCommand searchCommand) {
		return String.valueOf(searchService.selectChat(searchCommand));
	}
	
}
