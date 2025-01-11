package com.dipartimento.hoteldesperation.controller;

import com.dipartimento.hoteldesperation.dao.UserDAO;
import com.dipartimento.hoteldesperation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserDAO userDAO) {
        try {
            // Logica di registrazione (salvare l'utente nel database)
            userService.registerUser(userDAO);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception ed) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed");
        }
    }
}
