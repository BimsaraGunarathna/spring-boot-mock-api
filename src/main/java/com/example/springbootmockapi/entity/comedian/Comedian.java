package com.example.springbootmockapi.entity.comedian;

import com.example.springbootmockapi.entity.special.Special;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "comedian")
public class Comedian {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="name")
    private String name;

    @Column(name="role")
    private String role;


//    private long createdAt = new Date().getTime();
//    private String createdBy;
//    private long modifiedAt = new Date().getTime();
//    private String modifiedBy;

    public Comedian(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
