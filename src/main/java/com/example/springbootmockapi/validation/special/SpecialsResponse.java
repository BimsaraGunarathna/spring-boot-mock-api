package com.example.springbootmockapi.validation.special;

import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.model.special.Special;
import lombok.*;

import java.util.Collection;

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