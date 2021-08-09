package com.example.springbootmockapi.dto.comedian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class CreateComedianDTO {

    @JsonProperty("name")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("role")
    @NotEmpty(message = "Role can't be empty.")
    private String role;

    public CreateComedianDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
