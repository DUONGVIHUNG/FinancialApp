package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "balance_modes")
public class BalanceMode implements Serializable {
    private static final long serialVersionUID = -6355462386694894438L;

    @Id
    @Column(name = "id",unique = true,nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "total_balance_id", nullable = true)
    private UUID totalBalanceId;

    @Column(name = "mode_type",nullable = false,length = 30)
    private String modeType;

    @Column(name = "name",nullable = false,length = 50)
    private String name;

    @Column(name = "value",nullable = false)
    private Double value;

    @Column(name = "is_active",nullable = false)
    private boolean isActive;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate(){
        this.id = UUID.randomUUID();
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt=LocalDateTime.now();
    }
}
