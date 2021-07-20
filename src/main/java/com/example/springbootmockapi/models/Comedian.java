package com.example.springbootmockapi.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@NoArgsConstructor @Getter @Setter @ToString @EqualsAndHashCode
@Table(name = "Comedian")
public class Comedian {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String role;

    public Comedian(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Comedian(Long id, String name, String role) {
        this.name = name;
        this.role = role;
    }
    /*
    public Comedian(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Comedian(Long id, String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Comedian() {}

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Comedian))
            return false;
        Comedian comedian = (Comedian) o;
        return Objects.equals(this.id, comedian.id) && Objects.equals(this.name, comedian.name)
                && Objects.equals(this.role, comedian.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Comedian{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
    */
}
