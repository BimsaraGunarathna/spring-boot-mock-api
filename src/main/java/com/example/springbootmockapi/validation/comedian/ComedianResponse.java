package com.example.springbootmockapi.validation.comedian;

import com.example.springbootmockapi.model.comedian.Comedian;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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
