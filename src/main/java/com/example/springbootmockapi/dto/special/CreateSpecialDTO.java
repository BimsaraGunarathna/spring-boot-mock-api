package com.example.springbootmockapi.dto.special;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecialDTO {

        @JsonProperty("name")
        @NotEmpty(message = "Name can't be empty.")
        private String name;

        @JsonProperty("description")
        @NotEmpty(message = "Description can't be empty.")
        private String description;

        @JsonProperty("comedianId")
        private String comedianId;


}
