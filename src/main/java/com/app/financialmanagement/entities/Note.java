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
import jakarta.persistence.JoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

import io.swagger.v3.oas.annotations.Hidden;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "financial_notes")
public class Note implements Serializable {
    private static final long serialVersionUID = -954852873543850676L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true,nullable = false,updatable = false)
    private UUID id;

    @Column(name = "user_id",nullable = true)
    private UUID userId;

    @Column(name = "title", nullable = false ,length = 100)
    private String title;

    @Column(name = "description",nullable = false,length = 2000)
    private String description;

    @Column(name = "is_active",nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable = false)
    private LocalDateTime updatedAt;

    @Hidden
    @JsonIgnore
    @Exclude
    @OneToMany(mappedBy = "note", fetch = FetchType.LAZY)
    private Set<NoteTagMapping> noteTagMappings;

    @PrePersist
    void onCreate(){
        this.id = UUID.randomUUID();
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }



}
