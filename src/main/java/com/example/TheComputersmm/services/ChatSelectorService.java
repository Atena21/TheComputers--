package com.example.TheComputersmm.services;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.ChatListCommand;
import com.example.TheComputersmm.dto.ChatSelectionCommand;
import com.example.TheComputersmm.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatSelectorService {
	private SessionBean sessionBean;
	private RoomRepository roomRepository;
	
	@Autowired
	public ChatSelectorService(SessionBean sessionBean, RoomRepository roomRepository) {
		this.sessionBean = sessionBean;
		this.roomRepository = roomRepository;
	}
	
	public List<ChatListCommand> chats() {
		if(!validateRooms(sessionBean.getCurrentUser()))
			return null;
		
		List<ChatListCommand> chats = new ArrayList<ChatListCommand>();
		
		for(Room room : sessionBean.getCurrentUser().getRooms())
		{
			chats.add(convert(room));
		}
		
		
		return chats;
	}
	
	public boolean selectChat(ChatSelectionCommand chatSelectionCommand) {
		Room selectedRoom = roomRepository.findById(chatSelectionCommand.getChatId()).get();
		
		if(selectedRoom == null)
			return false;
		
		sessionBean.enterRoom(selectedRoom);
		return true;
	}
	

	private ChatListCommand convert(Room room) {
		return new ChatListCommand(room.getId(), room.getName(), "LastMessage");
	}

	private boolean validateRooms(User currentUser) {
		if(currentUser == null || currentUser.getRooms() == null)
			return false;
		return true;
	}
	
}
