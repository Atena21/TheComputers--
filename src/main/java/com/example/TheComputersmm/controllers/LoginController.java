package com.example.TheComputersmm.controllers;

import com.example.TheComputersmm.dto.LoginCommand;
import com.example.TheComputersmm.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
  private LoginService loginService;

  @Autowired
  public LoginController(LoginService loginService) {
    this.loginService = loginService;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "text/plain")
  @ResponseBody
  public String login(@RequestBody LoginCommand command) {
    this.loginService.login(command);
    if(this.loginService.isLogged())
    	return String.valueOf(loginService.userRole());
    return "NOT_LOGGED";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "text/plain")
  @ResponseBody
  public String logged() {
    return String.valueOf(this.loginService.isLogged());
  }
}
