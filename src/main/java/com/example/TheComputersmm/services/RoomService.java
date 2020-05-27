package com.example.TheComputersmm.services;

import com.example.TheComputersmm.domain.Message;
import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.AddUserToRoomCommand;
import com.example.TheComputersmm.dto.CreateRoomCommand;
import com.example.TheComputersmm.dto.DeleteRoomCommand;
import com.example.TheComputersmm.dto.GetLastMessageCommand;
import com.example.TheComputersmm.dto.MessageCommand;
import com.example.TheComputersmm.dto.RemoveUserFromRoomCommand;
import com.example.TheComputersmm.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

  private RoomRepository roomRepository;
  private MessageService messageService;
  private UserService userService;

  @Autowired
  public RoomService(
      RoomRepository roomRepository, MessageService messageService, UserService userService) {
    this.roomRepository = roomRepository;
    this.messageService = messageService;
    this.userService = userService;
  }

  public boolean create(CreateRoomCommand command) {
    Room room = this.findByName(command.getRoomName());

    if (room == null) {
      this.save(new Room(command.getRoomName()));
      return true;
    }
    return false;
  }

  public boolean delete(DeleteRoomCommand command) {
    Room room = this.findByName(command.getRoomName());
    if (room == null)
      return false;

    this.deleteById(room.getId());
    return true;
  }

  public List<Message> getMessages(Integer roomId) {
    return this.messageService.findAllByRoomIdOrderByCreatedDate(roomId);
  }

  public Boolean addUser(AddUserToRoomCommand command) {
    User user = this.userService.findByUsername(command.getUsername());
    Room room = this.findByName(command.getRoomName());

    if (user == null || room == null) return false;

    user.getRooms().add(room);
    room.getUsers().add(user);

    this.userService.save(user);
    this.save(room);
    return true;
  }

  public Boolean removeUser(RemoveUserFromRoomCommand command) {
    User user = this.userService.findByUsername(command.getUsername());
    Room room = this.findByName(command.getRoomName());

    if (user == null || room == null) return false;
    
    else if (!(user.getRooms().contains(room) || room.getUsers().contains(user))) return false;

    user.getRooms().remove(room);
    room.getUsers().remove(user);

    this.userService.save(user);
    this.save(room);
    return true;
  }
  
  public MessageCommand getLastMessage(GetLastMessageCommand command){
      Room room = this.findByName(command.roomName);
      List<Message> messages = this.getMessages(room.getId());
      Message lastMessage = messages.get(messages.size()-1);
      MessageCommand message = new MessageCommand(lastMessage.getText(),
              lastMessage.getUser().getUsername() ,lastMessage.getUser().getId(), 
              lastMessage.getRoom().getId());
      return message;      
  }

  private void deleteById(Integer id) {
    this.roomRepository.deleteById(id);
  }

  private Room findByName(String name) {
    return this.roomRepository.findByName(name);
  }

  private Room save(Room room) {
    return this.roomRepository.save(room);
  }
}
