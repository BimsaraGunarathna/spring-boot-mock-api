package com.example.springbootmockapi.entity.special;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

/*
@NoArgsConstructor

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "special")
*/
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
