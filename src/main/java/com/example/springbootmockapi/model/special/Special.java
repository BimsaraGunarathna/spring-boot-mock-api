package com.example.springbootmockapi.model.special;

import com.example.springbootmockapi.model.comedian.Comedian;
import lombok.*;

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
    @ManyToOne
    @JoinColumn(name="comedian_id")
    private Comedian comedian;


    public Special(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
