package com.codewithmosh.store.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;

@Mapper(componentModel = "spring") // so that spring can create beans of this class at runtime
public interface UserMapper { // in this interface we can define all types of mapping methods, here we want a method for mapping a user to a userdto
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())") // this is to set the createdAt field of the userdto to the current time when we map a user to a userdto, because the createdAt field is not present in the user entity, it's only present in the userdto, so we need to set it manually when we map a user to a userdto   
    UserDto toDto(User user); // the method here is toDto, it takes a user and returns a UserDto, mapstruct will generate the implementation of this method at runtime, it will map the fields of the user to the fields of the userdto based on their names

}
