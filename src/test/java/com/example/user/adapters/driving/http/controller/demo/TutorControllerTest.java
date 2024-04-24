package com.example.user.adapters.driving.http.controller.demo;

import com.example.user.adapters.driving.http.dtos.request.RegisterRequest;
import com.example.user.adapters.driving.http.mapper.RegisterRequestMapper;
import com.example.user.domain.api.IUserServicePort;
import com.example.user.domain.model.Roles;
import com.example.user.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

 class TutorControllerTest {

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private RegisterRequestMapper registerRequestMapper;

    @InjectMocks
    private TutorController tutorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    @WithMockUser(roles = {"ADMIN", "TUTOR"})
     void whenValidRegisterRequest_whenRegisterStudent_expectRegisterStudent() {
        // Given
        RegisterRequest registerRequest = new RegisterRequest("John", "Doe", 123456789L, 1234567890L, "test@example.com", "password");
        User validUser = new User();
        validUser.setId(1L);
        validUser.setName("Doe");
        validUser.setLastName("John");
        validUser.setDocIdent(123456789L);
        validUser.setEmail("test@example.com");
        validUser.setCellPhone(1234567890L);
        validUser.setPassword("password");
        validUser.setRole(new Roles(3L,"STUDENT"));

        when(registerRequestMapper.toRegister(registerRequest)).thenReturn(validUser);
        when(userServicePort.registerStudent(validUser)).thenReturn("success");

        // When
        ResponseEntity<String> response = tutorController.registerStudent(registerRequest);

        // Then
        verify(userServicePort).registerStudent(validUser);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
