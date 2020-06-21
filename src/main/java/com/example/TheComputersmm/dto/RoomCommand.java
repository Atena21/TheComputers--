package com.example.TheComputersmm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomCommand {
    private Integer id;
    private String name;

    public RoomCommand(@JsonProperty("id") Integer id,
                       @JsonProperty("name") String name)
    {
        this.id = id;
        this.name = name;
    }

    
    public Integer getId() {
        return id;
    }
    public String getName() {return name;}
}
