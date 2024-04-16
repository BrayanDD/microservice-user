package com.example.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.user.adapters.driven.jpa.mysql.adapter.UserJpaAdapter;
import com.example.user.adapters.driven.jpa.mysql.mappers.UserEntityMapper;
import com.example.user.adapters.driven.jpa.mysql.repository.RolRepository;
import com.example.user.adapters.driven.jpa.mysql.repository.UserRepository;
import com.example.user.configuration.jwt.JwtService;
import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.api.usecase.UserUseCase;
import com.example.user.domain.spi.IUserPersistencePort;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository,userEntityMapper,rolRepository,jwtService,authenticationManager);
    }

    @Bean
    public IUserServicePort userServicePort(){
        return new UserUseCase(userPersistencePort());
    }
}
