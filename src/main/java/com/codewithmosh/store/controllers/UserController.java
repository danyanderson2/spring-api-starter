package com.codewithmosh.store.controllers;


import java.util.Iterable

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    @GetMapping()   // alias for RequestMapping because...well it's shorter than RequestMapping
    // http methods can either be GET, PUT POST or DELETE
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

   @GetMapping("/{id}")
    public User getUser(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
}
