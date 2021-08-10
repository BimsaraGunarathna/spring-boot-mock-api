package com.example.springbootmockapi.exception;

/***
 * To handle Comedian Not Found Exception
 * @since 7/18/2021
 * @author Bimsara Gunarathna
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
