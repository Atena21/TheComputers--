package com.example.TheComputersmm.services;

import com.example.TheComputersmm.beans.SessionBean;
import com.example.TheComputersmm.domain.Type;
import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.dto.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class LoginService {

  private SessionBean sessionBean;
  private UserService userService;

  @Autowired
  public LoginService(SessionBean sessionBean, UserService userService) {
    this.sessionBean = sessionBean;
    this.userService = userService;
  }

  public void login(@RequestBody LoginCommand command) {
    String username = command.getUsername();
    String password = command.getPassword();
    User user =
        this.userService.findByUsername(username);

    if (validateUser(user, password)) sessionBean.login(user);
  }

  private boolean validateUser(User user, String password) {
	if(user == null || user.getPassword() == null) return false;
    return user.getPassword().equals(password);
  }

  public boolean isLogged() {
    return sessionBean.isLogged();
  }
  
  public Type userRole() {
	  return sessionBean.getLoggedRole();
  }
}
