package de.heisemedia.gateway.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.heisemedia.gateway.api.User;


@RestController
public class UserController {

    @RequestMapping( value = "/users/{id}", method = RequestMethod.GET )
    public HttpEntity<User> getUserById( @PathVariable( "id" ) final Long id ) {
        if( userExists( id ) ) {
            return ResponseEntity.ok( new User( id, "User " + id ) );
        }
        else {
            throw new UserNotFoundException( "User with id:" + id + " not found." );
        }
    }
    
    @ExceptionHandler( UserNotFoundException.class )
    public HttpEntity<String> handleMockServiceException( UserNotFoundException exception ) {
        return new ResponseEntity<String>( exception.getMessage(), HttpStatus.NOT_FOUND );
    }

    private boolean userExists( final Long id ) {
        return id > -1 && id < 10;
    }
}
