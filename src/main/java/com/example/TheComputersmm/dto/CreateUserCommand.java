package com.example.TheComputersmm.dto;

public class CreateUserCommand {
    public String username;
    public String password;
	public String retype;
    public String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetype() {
		return retype;
	}

	public void setRetype(String retype) {
		this.retype = retype;
	}
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
