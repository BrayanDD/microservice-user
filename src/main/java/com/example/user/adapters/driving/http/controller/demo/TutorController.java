package com.example.user.adapters.driving.http.controller.demo;

import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TutorController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final RegisterRequestMapper registerRequestMapper;

    @PostMapping(value = "registerStudent")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TUTOR')")
    public ResponseEntity<String> registerStudent(@Valid @RequestBody RegisterRequest registerRequest) {

        userServicePort.registerStudent(registerRequestMapper.toRegister(registerRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created");
    }
}

