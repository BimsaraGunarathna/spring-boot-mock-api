package com.example.springbootmockapi.validation.special;

import com.example.springbootmockapi.model.comedian.Comedian;
import com.example.springbootmockapi.model.special.Special;
import lombok.*;


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
