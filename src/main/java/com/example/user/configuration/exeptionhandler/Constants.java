package com.example.user.configuration.exeptionhandler;

public class Constants {

    private Constants(){
        throw new IllegalStateException("utility class");
    }
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "Email was found in the database";
    public  static final String PASSWORD_INCORRECT_EXCEPTION_MESSAGE = "The password is incorrect";
    public static final String EMAIL_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The User you want to register already exists";

}