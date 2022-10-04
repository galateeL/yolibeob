package com.poei2022.yolibeob.dao.entity;

import jakarta.ws.rs.Consumes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @Column
    private String email;

    @Column
    private String avatarUrl;

    @Column
    private String password;

    public User() {}

    public User(long id, String lastName, String firstName, String email, String avatarUrl, String password) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.password = password;
    }

    public User(String lastName, String firstName, String email, String avatarUrl, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.avatarUrl = avatarUrl;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
