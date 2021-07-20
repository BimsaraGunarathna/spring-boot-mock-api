package com.example.springbootmockapi.exceptions;

public class ComedianNotFoundException extends RuntimeException {
    public ComedianNotFoundException(Long id) {
        super("Could not find comedian " + id);
    }
}
