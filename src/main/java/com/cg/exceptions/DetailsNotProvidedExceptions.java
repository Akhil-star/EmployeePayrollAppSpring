package com.cg.exceptions;

public class DetailsNotProvidedExceptions  extends IllegalArgumentException{
    
    private static final long serialVersionUID = 7434529008585163424L;

    public DetailsNotProvidedExceptions(String message) {
        super(message);

    }
}
