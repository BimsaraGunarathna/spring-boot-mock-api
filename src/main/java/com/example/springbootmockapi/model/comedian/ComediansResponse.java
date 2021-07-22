package com.example.springbootmockapi.model.comedian;

import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ComediansResponse {
    private String message;
    private Collection<Comedian> comedians;

    public ComediansResponse(String message, Collection<Comedian> comedians) {
        this.message = message;
        this.comedians = comedians;
    }
}
