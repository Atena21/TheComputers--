package com.example.TheComputersmm.services;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.GetUserRoomsCommand;
import com.example.TheComputersmm.dto.SearchCommand;
import com.example.TheComputersmm.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
	private SessionBean sessionBean;
	private RoomRepository roomRepository;
	
	@Autowired
	public SearchService(SessionBean sessionBean, RoomRepository roomRepository) {
		this.sessionBean = sessionBean;
		this.roomRepository = roomRepository;
	}
	
	public List<GetUserRoomsCommand> chats() {
		if(!validateRooms(sessionBean.getCurrentUser()))
			return null;
		
		List<GetUserRoomsCommand> chats = new ArrayList<GetUserRoomsCommand>();
		
		for(Room room : sessionBean.getCurrentUser().getRooms())
		{
                    chats.add(convert(room));
		}
		
		
		return chats;
	}
	
	public boolean selectChat(SearchCommand searchCommand) {
		Room selectedRoom = roomRepository.findById(searchCommand.getChatId()).get();
		
		if(selectedRoom == null)
			return false;
		
		sessionBean.enterRoom(selectedRoom);
		return true;
	}
	

	private GetUserRoomsCommand convert(Room room) {
		return new GetUserRoomsCommand(room.getId(), room.getName(), "LastMessage");
	}

	private boolean validateRooms(User currentUser) {
		if(currentUser == null || currentUser.getRooms() == null)
			return false;
		return true;
	}
	
}
