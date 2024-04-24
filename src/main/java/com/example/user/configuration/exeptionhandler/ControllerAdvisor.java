package com.example.user.configuration.exeptionhandler;


import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.List;

import com.example.user.adapters.driven.jpa.mysql.exception.EmailAlreadyExistException;
import com.example.user.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.example.user.adapters.driven.jpa.mysql.exception.PasswordIncorrectException;
import com.example.user.domain.util.DomainConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor  {

    private ResponseEntity<ExceptionResponse> handleException(String message) {
        return ResponseEntity.badRequest().body(new ExceptionResponse(message, HttpStatus.NOT_FOUND.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionResponse> handlerNoDataFound(){
        return handleException(Constants.NO_DATA_FOUND_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<ExceptionResponse> handlerPasswordIncorrectException(){
        return handleException(Constants.PASSWORD_INCORRECT_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handlerEmailAlreadyExistException(){
        return handleException(Constants.EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(DomainConstants.UserNoFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException() {
        return handleException(DomainConstants.NO_DATA_FOUND_EXCEPTION_MESSAGE);

    }

    @ExceptionHandler(DomainConstants.UserExistException.class)
    public ResponseEntity<ExceptionResponse> handleUserExistExceptionn() {
        return handleException(DomainConstants.USER_ALREADY_EXISTS_EXCEPTION_MESSAGE);

    }
    @ExceptionHandler(DomainConstants.PasswordIncorrect.class)
    public ResponseEntity<ExceptionResponse> handlePasswordIncorrect() {
        return handleException(DomainConstants.PASSWORD_INCORRECT_EXCEPTION_MESSAGE);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ExceptionResponse response = new ExceptionResponse(
                "Validation Error",
                HttpStatus.BAD_REQUEST.toString(),
                LocalDateTime.now(),errorMessages
        );

        return ResponseEntity.badRequest().body(response);
    }



}

