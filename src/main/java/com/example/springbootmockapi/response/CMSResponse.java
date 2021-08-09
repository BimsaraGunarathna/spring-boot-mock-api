package com.example.springbootmockapi.response;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;
/**
 * Class for return unified response to api user
 * @author Buddhima Nanayakkara
 * @since 7/26/2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CMSResponse<T> {
    private HttpStatus code;
    private  T  payload;
    private String message;
    private long timestamp = new Date().getTime();

    public CMSResponse(HttpStatus code, T payload, String message) {
        this.code = code;
        this.payload = payload;
        this.message = message;
    }

}
