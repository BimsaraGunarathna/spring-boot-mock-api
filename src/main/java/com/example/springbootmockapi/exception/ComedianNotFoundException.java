package com.example.springbootmockapi.exception;

/***
 * To handle Comedian Not Found Exception
 * @since 7/18/2021
 * @author Bimsara Gunarathna
 */
public class ComedianNotFoundException extends RuntimeException {
    public ComedianNotFoundException(Long id) {
        super("Could not find comedian " + id);
    }
}
