package com.example.TheComputersmm;

import com.example.TheComputersmm.domain.User;
import com.example.TheComputersmm.services.UserService;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    private UserService userService;

    public ServletInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        User user1 = new User("Tiussi", "123", "tiussi@gmail.com");
        this.userService.save(user1);

        return application.sources(TheComputersmmApplication.class);
    }

}

