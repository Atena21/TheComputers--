package com.example.TheComputersmm.beans;

import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.Type;
import com.example.TheComputersmm.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionBean 
{
	private User sessionUser;
	
	private Room currentRoom;
	
	public void login(User user)
	{
		this.sessionUser = user;
	}
	
	public void logout()
	{
		this.sessionUser = null;
	}
	
	public boolean isLogged()
	{
		return sessionUser != null;
	}
	
	public String getUsername()
	{
		return sessionUser == null ? null : sessionUser.getUsername();
	}
	
	public Type getLoggedRole()
	{
		if(sessionUser == null)
			return null;
		return sessionUser.getType();
	}
	
	public void enterRoom(Room room) {
		this.currentRoom = room;
	}
	
	public Room getCurrentRoom() {
		return this.currentRoom;
	}
	
	public User getCurrentUser() {
		return this.sessionUser;
	}
	
}
