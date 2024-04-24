package com.example.user.domain.util;

public class DomainConstants {

    public static final String USER_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The User you want to register already exists";
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "Email was found in the database";
    public  static final String PASSWORD_INCORRECT_EXCEPTION_MESSAGE = "The password is incorrect";

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static class UserExistException extends RuntimeException {

        public UserExistException() {
            super(USER_ALREADY_EXISTS_EXCEPTION_MESSAGE);
        }
    }
    public static class UserNoFoundException extends RuntimeException {

        public UserNoFoundException() {
            super(NO_DATA_FOUND_EXCEPTION_MESSAGE);
        }
    }

    public static class PasswordIncorrect extends RuntimeException {

        public PasswordIncorrect() {
            super(PASSWORD_INCORRECT_EXCEPTION_MESSAGE);
        }
    }
}

