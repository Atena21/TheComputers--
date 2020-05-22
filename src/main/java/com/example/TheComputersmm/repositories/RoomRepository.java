package com.example.TheComputersmm.repositories;

import com.example.TheComputersmm.domain.Message;
import com.example.TheComputersmm.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
  public Room findByName(String roomName);


}
