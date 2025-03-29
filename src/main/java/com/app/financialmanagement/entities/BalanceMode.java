package com.app.financialmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import lombok.EqualsAndHashCode.Exclude;
import lombok.Data;

import io.swagger.v3.oas.annotations.Hidden;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
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

    @Exclude
    @Hidden
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "total_balance_id",nullable = true,updatable = false,insertable = false)
    private TotalBalance totalBalance;

    @Exclude
    @Hidden
    @JsonIgnore
    @OneToMany(mappedBy = "balanceMode", fetch = FetchType.LAZY)
    private Set<FutureTicket> futureTickets;

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
