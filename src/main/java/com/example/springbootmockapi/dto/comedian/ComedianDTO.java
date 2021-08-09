package com.example.springbootmockapi.dto.comedian;

import com.example.springbootmockapi.entity.special.Special;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
