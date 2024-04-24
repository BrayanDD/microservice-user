package com.example.user.adapters.driving.http.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotNull(message = "Email cannot be null")
    private String email;

    @NotNull(message = "Password cannot be null")
    private String password;
}

