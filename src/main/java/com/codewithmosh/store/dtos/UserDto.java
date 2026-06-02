package com.codewithmosh.store.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {
    // @JsonIgnore // exlude id
    // @JsonProperty("user_id") // rename 
    private Long id;
    private String name;
    private String email;
    // @JsonInclude(JsonInclude.Include.NON_NULL) // exclude phone number if it's null
    // private String phoneNumber;
    private LocalDateTime createdAt;

}
