package com.example.springbootmockapi.entity.comedian;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Comedian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    private String name;

    private String role;

    public Comedian(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
