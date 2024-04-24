package com.example.user.adapters.driving.http.controller;

import com.example.user.adapters.driving.http.dtos.request.LoginRequest;
import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.LoginRequestMapper;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.Roles;
import com.example.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

 class UserControllerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private LoginRequestMapper loginRequestMapper;

    @Mock
    private RegisterRequestMapper registerRequestMapper;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void givenValidLoginRequest_whenLogin_expectLoginSuccess() {
        // Given
        LoginRequest loginRequest = new LoginRequest("test@tes.com", "password");
        Login login = new Login("test@tes.com", "password");
        when(loginRequestMapper.toLogin(loginRequest)).thenReturn(login);
        when(userServicePort.login(login)).thenReturn("success");

        // When
        ResponseEntity<String> response = userController.login(loginRequest);

        // Then
        verify(userServicePort, times(1)).login(login);
        assertEquals("success", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void givenValidRegisterRequest_whenRegisterAdmin_expectRegisterAdmin() {
        // Given
        RegisterRequest registerRequest = new RegisterRequest("John", "Doe", 123456789L, 1234567890L, "test@example.com", "password");
        User validUser = new User();
        validUser.setId(1L);
        validUser.setName("prueba");
        validUser.setLastName("probado");
        validUser.setDocIdent(123L);
        validUser.setEmail("prueba@gamil.com");
        validUser.setCellPhone(1234L);
        validUser.setPassword("prueba");
        validUser.setRole(new Roles(1L,"ADMIN"));

        when(registerRequestMapper.toRegister(registerRequest)).thenReturn(validUser);
        when(userServicePort.registerAdmin(validUser)).thenReturn("success");

        // When
        ResponseEntity<String> response = userController.registerAdmin(registerRequest);

        // Then
        verify(userServicePort, times(1)).registerAdmin(validUser);
        assertEquals("success", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }


}
