package com.example.springbootmockapi.validation.special;

import com.example.springbootmockapi.entity.special.Special;
import lombok.*;

import java.util.Collection;

/***
 * To handle REST response for multiple specials.
 * @author Bimsara Gunarathna
 * @since 7/22/2021
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpecialsResponse {
    private String message;
    private Collection<Special> specials;

    public SpecialsResponse(String message, Collection<Special> specials) {
        this.message = message;
        this.specials = specials;
    }
}
