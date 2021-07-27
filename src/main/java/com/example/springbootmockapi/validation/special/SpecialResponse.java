package com.example.springbootmockapi.validation.special;

import com.example.springbootmockapi.entity.special.Special;
import lombok.*;


/***
 * to handle REST requests for single special.
 * @author Bimsara Gunarathna
 * @since 7/22/2021
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpecialResponse {

    private String message;
    private Special special;

    public SpecialResponse (String message, Special special) {
        this.message = message;
        this.special = special;
    }
}
