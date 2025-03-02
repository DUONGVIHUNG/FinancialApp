package com.app.financialmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Table;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "ticket_tag_mappings", uniqueConstraints = {@UniqueConstraint(columnNames = {"ticket_id","tag_id"})})
public class TicketTagMapping implements Serializable {
    private static final long serialVersionUID = 7485034351930195266L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true)
    private Integer id;

    @Column(name = "tag_id",nullable = true)
    private Integer tagID;

    @Column(name = "ticket_type",nullable = false)
    private String ticketType;

    @Column(name = "ticket_id",nullable = false)
    private UUID ticketId;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
