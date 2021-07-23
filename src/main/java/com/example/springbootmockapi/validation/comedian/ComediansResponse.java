package com.example.springbootmockapi.validation.comedian;

import com.example.springbootmockapi.model.comedian.Comedian;
import lombok.*;

import java.util.Collection;

/***
 * To handle REST response for multiple comedians.
 * @author Bimsara Gunarathna
 * @since 7/22/2021
 */
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
