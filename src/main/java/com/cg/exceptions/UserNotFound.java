package com.cg.exceptions;

public class UserNotFound extends IllegalArgumentException{
    
    private static final long serialVersionUID = -4638925546494764237L;

    public UserNotFound(String message) {
        super(message);
    }
}
