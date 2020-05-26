package com.example.TheComputersmm.services;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.RoomCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GetRoomsService {
    private SessionBean sessionBean;
    private User user;

    @Autowired
    public GetRoomsService(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Set<RoomCommand> getRoomsByUser() {
        Set<RoomCommand> result = new HashSet<>();
        Set<Room> rooms = sessionBean.getCurrentUser().getRooms();
        for(Room room: rooms)
            result.add(convert(room));
        return result;
    }

    public void setUser(User user) {this.user = user;}

    private RoomCommand convert(Room room) {
        return new RoomCommand(room.getId(), room.getName());
    }
}
