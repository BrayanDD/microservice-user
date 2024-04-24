package com.example.user.adapters.driving.http.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @NotNull(message = "Document identifier cannot be null")
    private Long docIdent;

    @NotNull(message = "Cell phone number cannot be null")
    private Long cellPhone;

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}

