package com.example.springbootmockapi.dto;

import com.example.springbootmockapi.entity.special.Special;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ComedianDTO {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @JsonProperty("comedianName")
    @NotEmpty(message = "Name can't be empty.")
    private String name;

    @JsonProperty("comedianRole")
    @NotEmpty(message = "Role can't be empty.")
    private String role;

    @JsonProperty("comedianSpecialIds")
    private List<Long> specialIds;

    @JsonIgnore
    @JsonProperty("comedianSpecials")
    private Set<Special> specials;


    public ComedianDTO(String name, String role, Set<Special> specials) {
        this.name = name;
        this.role = role;
        this.specials = specials;
    }

    public ComedianDTO(String name, String role) {
        this.name = name;
        this.role = role;

    }
}
