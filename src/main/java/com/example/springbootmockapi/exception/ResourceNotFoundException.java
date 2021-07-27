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
        //CMSResponse<Collection<Comedian>> comedianCMSResponse = new CMSResponse<Collection<Comedian>>(HttpStatus.NOT_FOUND.value(), null, message);
        //super(comedianCMSResponse);
        super(message);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

}
