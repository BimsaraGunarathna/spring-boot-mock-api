package com.example.springbootmockapi.entity.special;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "special")
public class Special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;

    @Column(name="comedianId")
    private Long comedianId;

    public Special(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Special(String name, String description, Long comedianId) {
        this.name = name;
        this.description = description;
        this.comedianId = comedianId;
    }

}
