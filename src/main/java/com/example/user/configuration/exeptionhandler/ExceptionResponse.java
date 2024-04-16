package com.example.user.configuration.exeptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class ExceptionResponse {
    private final String message;
    private final String status;
    private final LocalDateTime timestamp;
    private final List<String> errors;

   
    public ExceptionResponse(String message, String status, LocalDateTime timestamp) {
        this(message, status, timestamp, null); 
    }


    public ExceptionResponse(String message, String status, LocalDateTime timestamp, List<String> errors) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    
    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }
}
