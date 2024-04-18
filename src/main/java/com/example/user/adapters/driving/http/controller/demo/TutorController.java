package com.example.user.adapters.driving.http.controller.demo;

import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.PublicResponseMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TutorController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final PublicResponseMapper publicResponseMapper;
    public final RegisterRequestMapper registerRequestMapper;

    @PostMapping(value = "registerStudent")
    public ResponseEntity<Void> registerStudent(@RequestBody RegisterRequest registerRequest) {
        Long idRolCreate = 3L;
        userServicePort.register(registerRequestMapper.toRegister(registerRequest), idRolCreate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
