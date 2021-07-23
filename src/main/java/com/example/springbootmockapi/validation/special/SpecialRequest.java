package com.example.springbootmockapi.validation.special;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SpecialRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Description is mandatory")
    private String description;

    public SpecialRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
