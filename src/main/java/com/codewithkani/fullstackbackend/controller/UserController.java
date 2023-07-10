package com.codewithkani.fullstackbackend.controller;
import com.codewithkani.fullstackbackend.exception.UserNotFoundException;
import com.codewithkani.fullstackbackend.repository.UserRepository;
import com.codewithkani.fullstackbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }


    @PutMapping("user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                     user.setUsername(newUser.getUsername());
                     user.setName(newUser.getName());
                     user.setEmail(newUser.getEmail());
                     return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
}
