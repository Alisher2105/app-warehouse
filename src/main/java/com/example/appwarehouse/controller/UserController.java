package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.User;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.payload.UserDto;
import com.example.appwarehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Result addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("{id}")
    public Result editUserById(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.editUserById(id, userDto);
    }
}