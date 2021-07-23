package com.example.springbootmockapi.validation.comedian;

import com.example.springbootmockapi.model.comedian.Comedian;
import lombok.*;

/***
 * to handle REST requests for single comedian.
 * @author Bimsara Gunarathna
 * @since 7/22/2021
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ComedianResponse {

    private String message;
    private Comedian comedian;

    public ComedianResponse(String message, Comedian comedian) {
        this.message = message;
        this.comedian = comedian;
    }
}
