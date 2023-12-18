package com.ijse.demo.controller;

import com.ijse.demo.dto.UserPasswordDto;
import com.ijse.demo.entity.User;
import com.ijse.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}/change-password")
    public ResponseEntity<User> changePassword(@PathVariable long id, @RequestBody  UserPasswordDto userPasswordDto){
        return ResponseEntity.status(HttpStatus.OK).body(userService.changePassword(id,userPasswordDto));
    }
}
