// package com.example.user.adapters.driving.http.controller;

// import org.springframework.stereotype.Service;

// import com.example.user.adapters.driven.jpa.mysql.entity.Role;
// import com.example.user.adapters.driven.jpa.mysql.entity.RoleEntity;
// import com.example.user.adapters.driven.jpa.mysql.entity.UserEntity;
// import com.example.user.adapters.driven.jpa.mysql.repository.RolRepository;
// import com.example.user.adapters.driven.jpa.mysql.repository.UserRepository;
// import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
// import com.example.user.adapters.driving.http.dtos.response.PublicResponse;
// import com.example.user.configuration.jwt.JwtService;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class AuthService {

//     private final RolRepository rolRepository;
//     private final UserRepository userRepository;
//     private final JwtService jwtService;

//     public PublicResponse register(RegisterRequest request){
       
        

//         UserEntity user = UserEntity.builder()
//             .name(request.getName())
//             .lastName(request.getLastName())
//             .docIdent(request.getDocIdent())
//             .cellPhone(request.getCellPhone())
//             .email(request.getEmail())
//             .password(request.getPassword())
//             .role(Role.ADMIN)
//             .build();
        
//         userRepository.save(user);
//         return PublicResponse.builder()
//                 .token(jwtService.getToken(user))
//                 .build();
//     }
// }
