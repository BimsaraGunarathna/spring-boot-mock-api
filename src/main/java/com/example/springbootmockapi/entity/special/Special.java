package com.example.springbootmockapi.entity.special;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String description;

    private String comedianId;

    public Special(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Special(String name, String description, String comedianId) {
        this.name = name;
        this.description = description;
        this.comedianId = comedianId;
    }

}
