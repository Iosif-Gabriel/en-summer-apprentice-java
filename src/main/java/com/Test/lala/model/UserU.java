package com.Test.lala.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="UserU")
public class UserU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUser",nullable = false)
    private Long idUser;

    @Column(name="username",nullable = false)
    private String username;

    @Column(name="passwordUser",nullable = false,unique = true)
    private String password;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name="phoneNumber",nullable = false)
    private int phoneNumber;

    @OneToMany(mappedBy = "user")
    private List<OrderU> orders;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserU() {

    }

    public UserU(Long idUser, String username, String password, String email, int phoneNumber) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
