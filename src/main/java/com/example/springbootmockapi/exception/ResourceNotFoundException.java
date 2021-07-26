package com.example.springbootmockapi.exception;

/***
 * To handle Comedian Not Found Exception
 * @since 7/18/2021
 * @author Bimsara Gunarathna
 */
public class ResourceNotFoundException extends RuntimeException {
    //public ResourceNotFoundException(Long id) {
        //super("Could not find comedian " + id);
    //}
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
