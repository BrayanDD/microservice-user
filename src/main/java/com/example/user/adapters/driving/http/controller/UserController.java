package com.example.user.adapters.driving.http.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.adapters.driving.http.dtos.request.LoginRequest;
import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final RegisterRequestMapper registerRequestMapper;

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userServicePort.login(loginRequestMapper.toLogin(loginRequest)));
    }

    @PostMapping(value = "registerAdmin")
    public ResponseEntity<String> registerAdmin(@Valid @RequestBody RegisterRequest registerRequest){




        return ResponseEntity.ok(userServicePort.registerAdmin(registerRequestMapper.toRegister(registerRequest)));
    }
}
