package com.example.springbootmockapi.response;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CMSResponse<T> {
    private int code;
    private  T  payload;
    private String message;
    private long timestamp = new Date().getTime();

    public CMSResponse(int code, T payload, String message) {
        this.code = code;
        this.payload = payload;
        this.message = message;
    }
}
