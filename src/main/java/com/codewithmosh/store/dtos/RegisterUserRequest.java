package com.codewithmosh.store.dtos;

import lombok.Data;


@Data //replaces Getter, Setter, ...
public class RegisterUserRequest { //encapsulates all the data we need for sending data to a new user
   private String name;
   private String email;
   private String password;
}
