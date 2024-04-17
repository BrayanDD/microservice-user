package com.example.user.adapters.driving.http.controller.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdminController {

    @PostMapping(value = "registerTutor")

    public String registerStudent(){ return "registerTutor";}
}
