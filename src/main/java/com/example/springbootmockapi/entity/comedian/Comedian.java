package com.example.springbootmockapi.entity.comedian;

import com.example.springbootmockapi.entity.special.Special;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "comedian")
 */
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


//    private long createdAt = new Date().getTime();
//    private String createdBy;
//    private long modifiedAt = new Date().getTime();
//    private String modifiedBy;

    public Comedian(String name, String role) {
        this.name = name;
        this.role = role;
    }

}
