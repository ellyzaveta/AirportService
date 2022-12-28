package com.airportService.backend.controllers;

import com.airportService.backend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.Response;
import com.airportService.backend.models.Role;

@Controller
public class UserController {
    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void set(Role role, String password) {
        userService.set(role, password);
    }

    public Response<String> getPassword(Role role) {
        return userService.getPassword(role);
    }

    public void delete(Role role) {
        userService.delete(role);
    }
}
