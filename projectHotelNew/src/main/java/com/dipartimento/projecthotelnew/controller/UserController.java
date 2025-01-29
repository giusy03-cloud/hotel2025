package com.dipartimento.projecthotelnew.controller;


import com.dipartimento.projecthotelnew.model.User;
import com.dipartimento.projecthotelnew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUSer(@PathVariable int id){
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
