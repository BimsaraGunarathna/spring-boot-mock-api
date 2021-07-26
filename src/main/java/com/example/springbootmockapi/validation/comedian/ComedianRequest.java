package com.example.springbootmockapi.validation.comedian;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/***
 * to handle REST requests for a single comedian.
 * @author Bimsara Gunarathna
 * @since 7/22/2021
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ComedianRequest {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @NonNull
    private String name;

    @NotBlank(message = "Role is mandatory")
    private String role;

    public ComedianRequest(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
