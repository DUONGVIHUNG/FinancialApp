package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Table(name = "spending_threshold_records")
public class SpendingThresholdRecord implements Serializable {
    private static final long serialVersionUID = 9034204572897473307L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Integer id;

    @Column(name = "user_id",nullable = true)
    private UUID userID;

    @Column(name = "limit_value",nullable = false)
    private Double limitValue;

    @Column(name = "value_spent",nullable = false)
    private Double valueSpent;

    @Column(name = "month",nullable = false)
    private String month;

    @Column(name = "year", nullable = false)
    private String year;
}
