/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.TheComputersmm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author aless
 */
public class SendMessageCommand {
    private String text;
    private String roomName;
    private String username;
    
    public SendMessageCommand(@JsonProperty("text") String text,
            @JsonProperty("roomName") String roomName,
            @JsonProperty("username") String username){
        this.username = username;
        this.roomName = roomName;
        this.text = text;
        
    }
    
    public String getText(){
        return this.text;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getRoomName(){
        return this.roomName;
    }
}
