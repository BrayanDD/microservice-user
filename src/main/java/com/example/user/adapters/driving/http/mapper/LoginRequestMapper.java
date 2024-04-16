package com.example.user.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.user.adapters.driving.http.dtos.request.LoginRequest;
import com.example.user.domain.model.Login;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LoginRequestMapper {

    Login toLogin(LoginRequest loginRequest);

    
}
