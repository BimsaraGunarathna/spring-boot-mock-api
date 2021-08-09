package com.example.springbootmockapi.dto.special;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SpecialDTO {

    @Id
    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("description")
    @NotEmpty(message = "Name can't be empty.")
    private String description;

    @JsonProperty("comedianId")
    private String comedianId;

    public SpecialDTO(String name, String description) {

        this.name = name;
        this.description = description;
    }

    public SpecialDTO(String name, String description, String comedianId) {
        this.name = name;
        this.description = description;
        this.comedianId = comedianId;
    }


}
