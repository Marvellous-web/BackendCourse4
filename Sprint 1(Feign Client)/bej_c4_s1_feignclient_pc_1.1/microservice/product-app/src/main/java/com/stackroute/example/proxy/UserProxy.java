package com.stackroute.example.proxy;

import com.stackroute.example.domain.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "API-AUTHENTICATION",url = "localhost:9199")
public interface UserProxy {
    @PostMapping("/authentication-app/v1/register")
    public ResponseEntity<?> sendUserObjectToAuthApp(@RequestBody UserDTO userDTO);

}
