package com.codewithmosh.store.controllers;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;



import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;



import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping()   // alias for RequestMapping because...well it's shorter than RequestMapping
    // http methods can either be GET, PUT POST or DELETE
    public Iterable<UserDto> getAllUsers(
        @RequestParam(required=false, defaultValue="", name = "sort") String sort
    ){
        if (!Set.of( "name", "email").contains(sort)) // Set of valid values are name and email
        sort = "name"; // default value is name if the sort parameter is not provided or if it's not valid

        return userRepository.findAll(Sort.by(sort).ascending())  // it has a since it implements JpaRepository
        .stream()
        .map(user -> userMapper.toDto(user)) //userMapper::toDto is the same as user -> userMapper.toDto(user)
        .toList();
    }

   @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        var user =  userRepository.findById(id).orElse(null);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
