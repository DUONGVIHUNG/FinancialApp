package com.app.financialmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;



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

    @Exclude
    @Hidden
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id",nullable = true,insertable = false,updatable = false)
    private Tag tag;

    @PrePersist
    void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
