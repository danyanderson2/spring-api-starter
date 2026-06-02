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
    // @JsonIgnore // exlude id
    // @JsonProperty("user_id") // rename 
    private Long id;
    private String name;
    private String email;
    // @JsonInclude(JsonInclude.Include.NON_NULL) // exclude phone number if it's null
    // private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // format the date when we serialize it to json
    private LocalDateTime createdAt;

}
