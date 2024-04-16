package com.example.user.adapters.driven.jpa.mysql.mappers;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.user.domain.model.User;




@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    

    UserEntity toEntity(User user);
    
    User toUser(UserEntity userEntity);

    
}
