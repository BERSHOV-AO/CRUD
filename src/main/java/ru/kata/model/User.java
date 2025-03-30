package ru.kata.model;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name field is Empty")
    @Size(min = 2, max = 50, message = "Name should be in range between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "lastname field is Empty")
    @Size(min = 2, max = 50, message = "Name should be in range between 2 and 50 characters")
    @Column(name = "lastname")
    private String lastname;

    @Size(min = 2, max = 40, message = "Country should be in range between 2 and 40 characters")
    @Column(name = "country")
    private String country;

    public User(String name, String lastname, String country) {
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id
                && Objects.equals(name, user.name)
                && Objects.equals(lastname, user.lastname)
                && Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, country);
    }
}
