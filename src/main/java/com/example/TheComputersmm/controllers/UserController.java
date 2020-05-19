package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.domain.Room;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.*;
import com.example.TheComputersmm.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Set;

@Controller
public class UserController {
  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(value = "/newuser", method = RequestMethod.POST, produces = "text/plain")
  @ResponseBody
  public String createUser(@RequestBody CreateUserCommand command) {
    Boolean created = this.userService.create(command);
    return String.valueOf(created);
  }

  @RequestMapping(value = "/removeUser", method = RequestMethod.POST, produces = "text/plain")
  @ResponseBody
  public String removeUser(@RequestBody RemoveUserCommand command) {
    Boolean deleted = this.userService.delete(command);
    return String.valueOf(deleted);
  }

//  @RequestMapping(value = "/updateUserEmail", method = RequestMethod.POST, produces = "text/plain")
//  @ResponseBody
//  public String updateEmail(@RequestBody UpdateUserEmailCommand command) {
//    Boolean updated = this.userService.updateEmail(command);
//    return String.valueOf(updated);
//  }
//
//  @RequestMapping(value = "/updateUserPassword", method = RequestMethod.POST, produces = "text/plain")
//  @ResponseBody
//  public String updatePassword(@RequestBody UpdateUserPasswordCommand command) {
//    Boolean updated = this.userService.updatePassword(command);
//    return String.valueOf(updated);
//  }

  @RequestMapping(value = "/getUserRooms", method = RequestMethod.GET)
  @ResponseBody
  public Set<Room> getUserRooms(@RequestBody GetUserRoomsCommand command) {
    return this.userService.getRooms(command);
  }
  
  @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
  @ResponseBody
  public List<User> getUsers() {
    return this.userService.findAll();
  }
}
