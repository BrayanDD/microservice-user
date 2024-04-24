package com.example.user.adapters.driving.http.controller.demo;

import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;
import com.example.user.microserviceBootcamp.BootcampFeing;
import com.example.user.adapters.driving.http.dtos.response.TechnologyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.access.prepost.PreAuthorize;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdminController {

    public final IUserServicePort userServicePort;
    public final LoginRequestMapper loginRequestMapper;
    public final RegisterRequestMapper registerRequestMapper;

    private final BootcampFeing bootcampFeing;

    @PostMapping(value = "registerTutor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> registerTutor(@Valid @RequestBody RegisterRequest registerRequest) {

        userServicePort.registerTutor(registerRequestMapper.toRegister(registerRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("Tutor created");
    }

    @GetMapping("/technologiesFromBbootcamp")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<TechnologyDto>> getAllTechnologiesFromBootcamp(HttpServletRequest request) {
        List<TechnologyDto> technologies = bootcampFeing.getAllTechnologies(request.getHeader(HttpHeaders.AUTHORIZATION),1,2,"asc");
        return ResponseEntity.ok(technologies);
    }
}
