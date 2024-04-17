package com.example.user.adapters.driven.jpa.mysql.adapter;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.user.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.example.user.adapters.driven.jpa.mysql.mappers.UserEntityMapper;
import com.example.user.adapters.driven.jpa.mysql.repository.RolRepository;
import com.example.user.adapters.driven.jpa.mysql.repository.UserRepository;
import com.example.user.configuration.jwt.JwtService;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.PublicResponseTok;
import com.example.user.domain.model.User;
import com.example.user.domain.spi.IUserPersistencePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public String login(Login login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));
        UserDetails user = userRepository.findByEmail(login.getEmail()).orElseThrow();
        return jwtService.getToken(user);
    }

    @Override
    public String register(User register, Long idRolCreate) {
        
        UserEntity userEntity = userEntityMapper.toEntity(register);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        rolRepository.findById(idRolCreate).ifPresent(userEntity::setRole);

        UserEntity savedUserEntity = userRepository.save(userEntity);


        return jwtService.getToken(savedUserEntity);
    }


}
