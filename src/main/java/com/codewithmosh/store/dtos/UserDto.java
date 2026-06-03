package com.codewithmosh.store.dtos;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserDto {
    // @JsonIgnore // exclude id
    // @JsonProperty("user_id") // rename 
    private Long id;
    private String name;
    private String email;

}
