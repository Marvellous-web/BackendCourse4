package com.stackroute.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor @NoArgsConstructor @Data
public class UserDTO {

    private int user_id;
    String email,password,role;
}
