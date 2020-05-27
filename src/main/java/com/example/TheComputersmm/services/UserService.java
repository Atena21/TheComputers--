package com.example.TheComputersmm.services;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.domain.Room;

import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.*;
import com.example.TheComputersmm.repositories.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
  private UserRepository userRepository;
  private SessionBean sessionBean;

  @Autowired
  public UserService(UserRepository userRepository, SessionBean sessionBean) {
    this.userRepository = userRepository;
    this.sessionBean = sessionBean;
  }

  public boolean create(CreateUserCommand command) {
	String password = command.getPassword();
	String retype = command.getRetype();
	
	if (!password.equals(retype))
		return false;
	else {
	    User user = this.findByUsername(command.getUsername());
	    if (user == null) {
	      this.save(
	              new User(command.getUsername(),
	                      command.getPassword())
	      );
	      return true;
	    }
	    return false;
	}

  }

  public boolean delete(RemoveUserCommand command) {
    User user = this.findByUsername(command.getUsername());
    if (user == null)
      return false;

    this.deleteById(user.getId());
    return true;
  }

  public boolean updatePassword(UpdateUserPasswordCommand command) {
    User user = this.findByUsername(command.getUsername());
    if (user == null)
      return false;

    user.setPassword(command.getPassword());
    this.save(user);
    return true;
  }

  public Set<Room> getRooms(UserCommand command) {
    User user = this.findByUsername(command.getUsername());
    if(user == null)
      return new HashSet<>();

    return user.getRooms();
  }



  public User findByUsername(String username) {
    return this.userRepository.findByUsername(username);
  }

  public User save(User user) {
    return this.userRepository.save(user);
  }

  public void deleteById(Integer id) {
    this.userRepository.deleteById(id);
  }

  public List<User> findAll() {
    return this.userRepository.findAll();
  }
  
  public List<UserCommand> getUsers(){
      List<UserCommand> list = new ArrayList<UserCommand>();
      List<User> users = findAll();
      User currentUser = sessionBean.getCurrentUser();
      for(User user : users){
          if(user.getUsername().equals(currentUser.getUsername())) 
              continue;
          UserCommand item = new UserCommand();
          item.setUsername(user.getUsername());
          list.add(item);
      }
      return list;
  }


}
