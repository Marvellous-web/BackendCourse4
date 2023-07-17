package com.stackroute.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class CommonUser {
    private String username,password,role,email,mob_num;
}
