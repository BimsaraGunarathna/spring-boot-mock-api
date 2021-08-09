package com.example.springbootmockapi.dto.comedian;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateComedianDTO {

    @JsonProperty("name")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("role")
    @NotEmpty(message = "Role can't be empty.")
    private String role;

}
