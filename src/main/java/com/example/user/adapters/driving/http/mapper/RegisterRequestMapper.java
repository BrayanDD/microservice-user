package com.example.user.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;

import com.example.user.domain.model.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegisterRequestMapper {

    User toRegister(RegisterRequest registerRequest);


}
