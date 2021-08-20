package com.digicore.digicore.controllers.authentication;

import com.digicore.digicore.dto.accountCreation.CreateAccountDto;
import com.digicore.digicore.dto.accountCreation.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Authentication {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto requestData){
        return null;
    }
}
