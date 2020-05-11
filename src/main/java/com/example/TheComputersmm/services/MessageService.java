package com.example.TheComputersmm.services;

import com.example.TheComputersmm.domain.Message;
import com.example.TheComputersmm.dto.MessageCommand;
import com.example.TheComputersmm.repositories.MessageRepository;
import com.example.TheComputersmm.repositories.RoomRepository;
import com.example.TheComputersmm.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private SimpMessagingTemplate simpMessagingTemplate;
    private RoomRepository roomRepository;
    private UserRepository userRepository;
//    private SessionBean sessionBean;

    @Autowired
    public MessageService(MessageRepository messageRepository,
    					  SimpMessagingTemplate simpMessagingTemplate,
    					  RoomRepository roomRepository,
    					  UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public List<Message> findAllByRoomIdOrderByCreatedDate(Integer roomId) {
        return this.messageRepository.findAllByRoomIdOrderByCreatedDate(roomId);
    }
    
    public void receiveMessage(MessageCommand message) {
    	messageRepository.save(convert(message));
    	this.simpMessagingTemplate.convertAndSend("/topic/" + message.getRoomId().toString(), message);
    }

	private Message convert(MessageCommand message) {
		Message newMessage = new Message();
		newMessage.setText(message.getContent());
		newMessage.setRoom(roomRepository.findById(message.getRoomId()).get());
		newMessage.setUser(userRepository.findById(message.getUserId()).get());
		return newMessage;
	}
}
