package com.example.springbootmockapi.dto.special;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CreateSpecialDTO {

        @JsonProperty("name")
        @NotEmpty(message = "Name can't be empty.")
        private String name;

        @JsonProperty("description")
        @NotEmpty(message = "Description can't be empty.")
        private String description;

        public CreateSpecialDTO(String name, String description) {

            this.name = name;
            this.description = description;
        }

}
