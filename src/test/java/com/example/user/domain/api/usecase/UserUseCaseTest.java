package com.example.user.domain.api.usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import com.example.user.domain.model.Login;
import com.example.user.domain.model.User;
import com.example.user.domain.spi.IUserPersistencePort;
import com.example.user.domain.api.IUserServicePort;


 class UserUseCaseTest {

    @Mock
    private IUserPersistencePort userPersistencePort;

    @Mock
    private IUserServicePort userServicePort;

    @InjectMocks
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void givenValidLogin_whenLogin_thenPassToPersistencePort() {
        // Given
        Login validLogin = new Login();
        validLogin.setEmail("prueba@gmail.com");
        validLogin.setPassword("probate");
        // When
        userUseCase.login(validLogin);

        // Then
        verify(userPersistencePort, times(1)).login(validLogin);
    }

    @Test
    void givenValidUser_whenRegisterAdmin_thenPassToPersistencePortWithAdminRoleId() {
       // Given
       User validUser = new User();
       validUser.setId(null);
       validUser.setName("probate");
       validUser.setLastName("prob ado");
       validUser.setDocIdent(123L);
       validUser.setEmail("prueba@gamil.com");
       validUser.setCellPhone(1234L);
       validUser.setPassword("probate");
       validUser.setRole(null);
       // Setear los atributos del usuario
       Long adminRoleId = 1L;

       // When
       userUseCase.registerAdmin(validUser);

       // Then
       verify(userPersistencePort, times(1)).register(validUser, adminRoleId);
    }

    @Test
    void givenValidUser_whenRegisterTutor_thenPassToPersistencePortWithTutorRoleId() {
       // Given
       User validUser = new User();
       validUser.setId(null);
       validUser.setName("probate");
       validUser.setLastName("prob ado");
       validUser.setDocIdent(123L);
       validUser.setEmail("prueba@gamil.com");
       validUser.setCellPhone(1234L);
       validUser.setPassword("probate");
       validUser.setRole(null);
       Long tutorRoleId = 2L;

       // When
       userUseCase.registerTutor(validUser);

       // Then
       verify(userPersistencePort, times(1)).register(validUser, tutorRoleId);
    }

    @Test
    void givenValidUser_whenRegisterStudent_thenPassToPersistencePortWithStudentRoleId() {
       // Given
       User validUser = new User();
       validUser.setId(null);
       validUser.setName("probate");
       validUser.setLastName("prob ado");
       validUser.setDocIdent(123L);
       validUser.setEmail("prueba@gamil.com");
       validUser.setCellPhone(1234L);
       validUser.setPassword("probate");
       validUser.setRole(null);
       Long studentRoleId = 3L;

       // When
       userUseCase.registerStudent(validUser);

       // Then
       verify(userPersistencePort, times(1)).register(validUser, studentRoleId);
    }

 }
