package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 5155736403725997140L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true,updatable = false)
    private UUID id;

    @Column(name = "email_id",nullable = false,unique = true,length = 50)
    private String emailID;

    @Column(name = "password",nullable = false,length = 150)
    private String password;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = true)
    private String lastName;

    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate(){
        this.id=UUID.randomUUID();
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt=LocalDateTime.now();
    }

}
