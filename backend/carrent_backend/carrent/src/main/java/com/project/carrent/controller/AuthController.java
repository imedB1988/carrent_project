package com.project.carrent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.carrent.dto.SignupRequest;
import com.project.carrent.dto.UserDto;
import com.project.carrent.services.auth.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")    
    public ResponseEntity<?> signupCustomer(@RequestBody SignupRequest signupRequest){
        if(authService.hasCustomerWithEmail(signupRequest.getEmail()))
            return new ResponseEntity<>("User already created", HttpStatus.NOT_ACCEPTABLE);
            
        UserDto dto = authService.createCustomer(signupRequest);
        if(dto==null) return new ResponseEntity<>("customer not created", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

 
}
