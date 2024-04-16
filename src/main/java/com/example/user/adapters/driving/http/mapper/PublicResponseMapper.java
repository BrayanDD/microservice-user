package com.example.user.adapters.driving.http.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.user.adapters.driving.http.dtos.response.PublicResponse;
import com.example.user.configuration.jwt.JwtService;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.PublicResponseTok;
import com.example.user.domain.model.User;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PublicResponseMapper {



    PublicResponse toPublicResponse(PublicResponseTok publicResponseTok);
}

