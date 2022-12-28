package com.airportService.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.airportService.backend.models.Role;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class AuthenticationController {
    private final MessageDigest encoder;
    @Autowired
    private final UserController userController;

    public AuthenticationController(UserController userController) throws NoSuchAlgorithmException {
        this.userController = userController;
        encoder = MessageDigest.getInstance("SHA-256");
    }

    public String encode(String password) {
        encoder.update(password.getBytes());
        return new String(encoder.digest());
    }

    public boolean authentication(Role role, String password) {
        encoder.update(password.getBytes());
        String encoded = new String(encoder.digest());
        return encoded.equals(userController.getPassword(role).get());
    }
}
