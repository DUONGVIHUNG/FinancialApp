package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "current_monthly_spending_threshold_limits")
public class CurrentMonthlySpendingThresholdLimit implements Serializable {
    private static final long serialVersionUID = -1092512212071687815L;

    @Id
    @Column(name = "id",nullable = false,updatable = false,unique = true,insertable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id",nullable = true)
    private UUID userID;

    @Column(name = "limit_value",nullable = false)
    private Double limitValue;

    @Column(name = "is_active",nullable = false)
    private Boolean isActive;

}
