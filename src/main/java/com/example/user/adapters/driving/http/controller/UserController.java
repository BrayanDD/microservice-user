package com.example.user.adapters.driving.http.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.user.adapters.driving.http.dtos.request.LoginRequest;
import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.dtos.response.PublicResponse;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.PublicResponseMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.configuration.jwt.JwtService;
import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.model.PublicResponseTok;
import com.example.user.domain.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final PublicResponseMapper publicResponseMapper;
    public final RegisterRequestMapper registerRequestMapper;
    public final JwtService jwtService;

    @PostMapping(value = "login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userServicePort.login(loginRequestMapper.toLogin(loginRequest)));
    }

    @PostMapping(value = "registerAdmin")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterRequest registerRequest){

        Long idRolCreate = 1L;


        return ResponseEntity.ok(userServicePort.register(registerRequestMapper.toRegister(registerRequest),idRolCreate));
    }
}
