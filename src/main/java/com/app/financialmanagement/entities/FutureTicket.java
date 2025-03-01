package com.app.financialmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name="future_tickets")
public class FutureTicket implements Serializable {
    private static final long serialVersionUID = 764699031042581465L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,unique = true,updatable = false)
    private UUID id;

    @Column(name="user_id",nullable = true)
    private UUID userID;

    @Column(name="balance_mode_id",nullable = true)
    private UUID balanceModeID;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description",nullable = true,length = 500)
    private String description;

    @Column(name="ticket_type",nullable = false)
    private String ticketType;

    @Column(name="value",nullable = false)
    private Double value;

    @Column(name="ticket_completion_date",nullable = true)
    private LocalDate ticketCompletionDate;

    @Column(name="created_at",nullable = false)
    private LocalDate createdAt;

    @Column(name="updated_at",nullable = false)
    private LocalDate updatedAt;

    @PrePersist
    void onCreate(){
        this.id = UUID.randomUUID();
        this.createdAt=LocalDate.now();
        this.updatedAt=LocalDate.now();
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt=LocalDate.now();
    }

}
