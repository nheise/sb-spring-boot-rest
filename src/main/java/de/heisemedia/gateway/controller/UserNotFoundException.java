package de.heisemedia.gateway.controller;


public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6235445433821531122L;

    public UserNotFoundException( String message ) {
        super( message );
    }

}
