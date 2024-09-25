package com.skillproof.api.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="user")
public class User {

    @Id
    @Size(max=20)
    @Column(name ="id", unique = true)
    private String id;

    @Basic
    @Size(max=100)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Basic
    @Size(max=100)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Basic
    @Size(max=100)
    @Column(name = "email_address", nullable = false, unique = true)
    private String emailAddress;

    @Basic
    @Size(max=201)
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Basic
    @Column(name = "password", nullable = false)
    private String password;

    @Basic
    @Size(max=250)
    @Column(name = "city", nullable = false)
    private String city;

    @Basic
    @Size(max=20)
    @Column(name = "phone")
    private String phone;

    @Basic
    @Column(name = "bio")
    private String bio;

    @Basic
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createdDate;

    @Basic
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updatedDate;

}
