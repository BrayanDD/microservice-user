package com.example.user.adapters.driven.jpa.mysql.adapter;


import com.example.user.adapters.driven.jpa.mysql.exception.EmailAlreadyExistException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.user.adapters.driven.jpa.mysql.mappers.UserEntityMapper;
import com.example.user.adapters.driven.jpa.mysql.repository.RolRepository;
import com.example.user.adapters.driven.jpa.mysql.repository.UserRepository;
import com.example.user.configuration.jwt.JwtService;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.User;
import com.example.user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;



@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(Login login) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));

        UserDetails user = userRepository.findByEmail(login.getEmail()).orElseThrow();
        return jwtService.getToken(user);

    }

    @Override
    public String register(User register, Long idRolCreate) {
        if (!verifyByEmail(register.getEmail())) {
            throw new EmailAlreadyExistException();
        }

        encoderPassword(register);
        UserEntity userEntity = userEntityMapper.toEntity(register);

        rolRepository.findById(idRolCreate).ifPresent(userEntity::setRole);

        UserEntity savedUserEntity = userRepository.save(userEntity);

        return jwtService.getToken(savedUserEntity);
    }



    private boolean verifyByEmail(String email) {
        return userRepository.findByEmail(email).isEmpty();
    }

    private void encoderPassword(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }



}
