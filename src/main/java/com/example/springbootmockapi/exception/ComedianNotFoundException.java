package com.example.springbootmockapi.exception;

public class ComedianNotFoundException extends RuntimeException{
    public ComedianNotFoundException(Long id) {
    super("Could not find comedian " + id);
    }
}
