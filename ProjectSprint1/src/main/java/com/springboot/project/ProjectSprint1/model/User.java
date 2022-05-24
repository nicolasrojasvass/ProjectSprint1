package com.springboot.project.ProjectSprint1.model;

import com.springboot.project.ProjectSprint1.controller.dto.UserDTO;

import java.util.UUID;

public class User {
    private String idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String username;

    public User(String firstName, String lastName, String email, String username) {
        this.idUser = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }

    public User(UserDTO userDTO) {
        this(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getUsername());
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
