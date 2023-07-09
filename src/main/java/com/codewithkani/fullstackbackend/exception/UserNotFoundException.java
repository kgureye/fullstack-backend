package com.codewithkani.fullstackbackend.exception;



public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Cannot find the user with " + id);
    }
}
