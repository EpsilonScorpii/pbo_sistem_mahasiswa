package com.kelbongcin.sistem_mahasiswa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users;

    private String email;
    private String password;
    private String roles;
    public User() {}

    public Long getId() {
        return id_users;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Object getId_users() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId_users'");
    }
}