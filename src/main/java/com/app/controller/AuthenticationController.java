package com.app.controller;

import com.app.controller.dto.AuthCreateUserRequest;
import com.app.controller.dto.AuthLoginRequest;
import com.app.controller.dto.AuthResponse;
import com.app.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest authLoginRequest) {
        return new ResponseEntity<>(this.userDetailService.loginUser(authLoginRequest), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest authCreateUserRequest) {
        return new ResponseEntity<>(this.userDetailService.createUser(authCreateUserRequest), HttpStatus.CREATED);
    }
}
