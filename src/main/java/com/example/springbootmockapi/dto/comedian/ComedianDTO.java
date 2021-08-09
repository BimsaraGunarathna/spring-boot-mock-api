package com.example.springbootmockapi.dto.comedian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ComedianDTO {

    @Id
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("role")
    @NotEmpty(message = "Role can't be empty.")
    private String role;

    public ComedianDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
