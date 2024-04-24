package com.example.user.adapters.driving.http.controller.demo;

import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;


import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;


import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdminController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final RegisterRequestMapper registerRequestMapper;



    @PostMapping(value = "registerTutor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerTutor(@Valid @RequestBody RegisterRequest registerRequest) {

        userServicePort.registerTutor(registerRequestMapper.toRegister(registerRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Tutor created");
    }


}
