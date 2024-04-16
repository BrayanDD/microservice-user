package com.example.user.adapters.driving.http.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Long id;
    private String name;
    private String lastName;
    private Long docIdent;
    private Long cellPhone;
    private String email;
    private String password;

    
}
