package com.app.financialmanagement.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @PrePersist
    void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
}
