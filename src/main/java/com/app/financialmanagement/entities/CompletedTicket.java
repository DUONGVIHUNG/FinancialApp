package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name="completed_tickets")
public class CompletedTicket implements Serializable {
    private static final long serialVersionUID = -5235224325275100751L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",nullable = false,unique = true,updatable = false)
    private UUID id;

    @Column(name="user_id",nullable = true)
    private UUID userID;

    @Column(name="balance_mode_id",nullable = true)
    private UUID balanceModeID;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true, length = 500)
    private String description;

    @Column(name = "ticket_type",nullable = false)
    private String ticketType;

    @Column(name="value",nullable = false)
    private Double value;

    @Column(name = "ticket_completion_date",nullable = true)
    private LocalDate ticketCompletionDate;

    @Column(name="created_at",nullable = false)
    private LocalDateTime createdAt;

    @Column(name="updated_at",nullable = false)
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
