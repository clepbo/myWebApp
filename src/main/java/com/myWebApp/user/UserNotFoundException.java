package com.myWebApp.user;

public class UserNotFoundException extends Throwable {


    public UserNotFoundException(String message) {
        super(message);
    }
}
