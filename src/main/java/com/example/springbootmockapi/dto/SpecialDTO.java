package com.example.springbootmockapi.dto;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SpecialDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("comedianName")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("specialDescription")
    @NotEmpty(message = "Name can't be empty.")
    private String description;

    @JsonProperty("specialComedianId")
    private Long comedianId;

    @JsonIgnore
    @JoinColumn(name="comedian_id")
    private Comedian comedian;


    public SpecialDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
