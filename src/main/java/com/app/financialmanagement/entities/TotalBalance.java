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
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

import io.swagger.v3.oas.annotations.Hidden;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "total_balances")
public class TotalBalance implements Serializable {
    private static final long serialVersionUID = -337603188367530726L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true,nullable = false,updatable = false)
    private UUID id;

    @Column(name = "user_id",nullable = true)
    private UUID userId;

    @Column(name = "created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Exclude
    @Hidden
    @JsonIgnore
    @OneToMany(mappedBy = "totalBalance",fetch = FetchType.LAZY)
    private List<BalanceMode> balanceModes;

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
