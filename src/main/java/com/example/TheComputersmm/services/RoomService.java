package com.example.TheComputersmm.services;

import com.example.TheComputersmm.domain.Message;
import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.*;
import com.example.TheComputersmm.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

  private RoomRepository roomRepository;
  private MessageService messageService;
  private UserService userService;
  private MessageCommand nullMessage = new MessageCommand ("","",0,0);

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
  
  public RoomCommand getRoom(CreateRoomCommand command){
      Room room = this.findByName(command.getRoomName());      
      RoomCommand roomCommand = new RoomCommand(room.getId(), room.getName());
      return roomCommand;
  }

  public boolean delete(DeleteRoomCommand command) {
    Room room = this.findByName(command.getRoomName());
    if (room == null)
      return false;

    this.deleteById(room.getId());
    return true;
  }

  public List<MessageCommand> getMessages(RoomCommand room) {
    List <MessageCommand> list = new ArrayList<>();
    List <Message> messages = messageService.findAllByRoomIdOrderByCreatedDate(room.getId());

    for (Message message : messages){
      MessageCommand item = new MessageCommand();
      item.setContent(message.getText());
      item.setRoomId(message.getRoom().getId());
      item.setUserId(message.getUser().getId());
      item.setUsername(message.getUser().getUsername());
      list.add(item);
    }
    if (list.size() == 0) {
      list.add(nullMessage);
    }
    return list;
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
  
  public MessageCommand getLastMessage(RoomCommand command){
    List <MessageCommand> messages = this.getMessages(command);
    MessageCommand message = messages.size() == 0? nullMessage : messages.get(messages.size()-1);
    return message;
  }

  private void deleteById(Integer id) {
    this.roomRepository.deleteById(id);
  }

  public Room findByName(String name) {
    return this.roomRepository.findByName(name);
  }

  private Room save(Room room) {
    return this.roomRepository.save(room);
  }
}
