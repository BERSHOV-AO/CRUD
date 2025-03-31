package ru.kata.model;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name field is Empty")
    @Size(min = 2, max = 50, message = "Name should be in range between 2 and 50 characters")
    @Column(name = "name")
    private String name;


    @NotEmpty(message = "Lastname field is Empty")
    @Size(min = 2, max = 50, message = "Lastname should be in range between 2 and 50 characters")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Email field is Empty")
    @Size(min = 6, max = 40, message = "Email should be in range between 2 and 40 characters")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, email);
    }
}