package com.example.springbootmockapi.dto.special;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SpecialDTO {

    private String id;

    @JsonProperty("name")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("description")
    @NotEmpty(message = "Name can't be empty.")
    private String description;

    @JsonProperty("comedianId")
    private String comedianId;

    public SpecialDTO(String name, String description, String comedianId) {

        this.name = name;
        this.description = description;
        this.comedianId = comedianId;
    }

}
