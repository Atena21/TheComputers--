package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.dto.RoomCommand;
import com.example.TheComputersmm.services.ChatService;
import com.example.TheComputersmm.services.GetRoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

public class GetRoomsController {
    private GetRoomsService getRoomsService;


    @Autowired
    public GetRoomsController(GetRoomsService getRoomsService) 	{
        this.getRoomsService = getRoomsService;

    }



    @RequestMapping(value = "/getRoomsByUser", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public Set<RoomCommand> getRoomsByUser () {
        return getRoomsService.getRoomsByUser();
    };
}
