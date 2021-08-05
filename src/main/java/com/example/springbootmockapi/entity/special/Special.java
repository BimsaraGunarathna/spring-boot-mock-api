package com.example.springbootmockapi.entity.special;

import com.example.springbootmockapi.entity.comedian.Comedian;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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

    //@ManyToOne (
            //fetch = FetchType.LAZY,
            //optional = false
    //)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    //@JoinColumn(name="comedian_id")
    //private Comedian comedian;


    public Special(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Special(String name, String description, Comedian comedian) {
        this.name = name;
        this.description = description;
    }

}
