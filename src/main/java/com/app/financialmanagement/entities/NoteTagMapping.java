package com.app.financialmanagement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.JoinColumn;

import lombok.EqualsAndHashCode.Exclude;
import lombok.Data;

import io.swagger.v3.oas.annotations.Hidden;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "note_tag_mappings", uniqueConstraints = {@UniqueConstraint(columnNames = {"tag_id", "note_id"})})
public class NoteTagMapping implements Serializable {
    private static final long serialVersionUID = -1177635991384609405L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, unique = true)
    private Integer id;

    @Column(name = "tag_id",nullable = true)
    private Integer tagId;

    @Column(name = "note_id",nullable = true)
    private UUID noteID;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    @Hidden
    @Exclude
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id",nullable = true,updatable = false,insertable = false)
    private Tag tag;

    @Hidden
    @Exclude
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name="note_id",nullable = true,updatable = false,insertable = false)
    private Note note;

    @PrePersist
    void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
}
